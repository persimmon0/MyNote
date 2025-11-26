# MyNote
Excel工作表:https://docs.google.com/spreadsheets/d/1I4bho8Ub2uZCyniBZqzRbjJkJsCHnAiTS9Zl4Z6ug_k/edit?gid=0#gid=0
Github:https://github.com/persimmon0/MyNote.git

參考教學:
1.https://blog.csdn.net/WenZhengshi/article/details/127702606
2.https://www.bilibili.com/video/BV1w7411o7EB?spm_id_from=333.788.videopod.episodes

gemini範例:https://gemini.google.com/share/465ae0e8ad00
gemini code:
import React, { useState } from 'react';
import { 
  Plus, 
  LogOut, 
  FileText, 
  FolderPlus, 
  ArrowRight,
  ChevronRight,
  Save,
  Trash2,
  Calendar,
  Clock
} from 'lucide-react';

// --- 模擬資料 ---
const DEFAULT_USERNAME = 'LoveJava';

const INITIAL_NOTES = [
  { 
    id: 1, 
    title: 'Java 學習筆記', 
    content: '今天學到了物件導向...\n1. 封裝\n2. 繼承\n3. 多型', 
    createdAt: '2023-10-24',
    updatedAt: '2023-10-25'
  },
  { 
    id: 2, 
    title: '待辦事項', 
    content: '- [ ] 複習 Spring Boot\n- [ ] 寫作業', 
    createdAt: '2023-10-23',
    updatedAt: '2023-10-23'
  },
  { 
    id: 3, 
    title: '專案構想', 
    content: '資料庫設計...\n使用者 table schema', 
    createdAt: '2023-10-20',
    updatedAt: '2023-10-24'
  },
];

export default function App() {
  const [user, setUser] = useState(null); // null = 未登入
  const [usernameInput, setUsernameInput] = useState(DEFAULT_USERNAME);
  
  const [notes, setNotes] = useState(INITIAL_NOTES);
  const [activeNoteId, setActiveNoteId] = useState(null);
  
  // 模擬登入
  const handleLogin = (e) => {
    e.preventDefault();
    if (usernameInput.trim()) {
      setUser({ id: 'u1', username: usernameInput });
    }
  };

  // 模擬登出 (已修復: 移除 window.confirm)
  const handleLogout = () => {
    // 移除 window.confirm/alert 是為了確保在沙箱環境中程式碼能順利執行
    // 實際應用中，您應該替換成自訂的 modal 彈窗來詢問用戶
    setUser(null);
    setActiveNoteId(null);
  };

  // 取得今天的日期字串
  const getTodayString = () => new Date().toISOString().split('T')[0];

  // 創建新筆記
  const createNote = () => {
    const newNote = {
      id: Date.now(),
      title: '無標題筆記',
      content: '',
      createdAt: getTodayString(),
      updatedAt: getTodayString()
    };
    setNotes([newNote, ...notes]);
    setActiveNoteId(newNote.id);
  };

  // 刪除筆記 (已修復: 移除 window.confirm)
  const handleDeleteNote = () => {
    if (!activeNoteId) return;
    
    // 這裡我們直接執行刪除，跳過確認步驟
    const newNotes = notes.filter(n => n.id !== activeNoteId);
    setNotes(newNotes);
    setActiveNoteId(null); 
  };

  // 模擬儲存
  const handleSave = () => {
    if (activeNoteId) {
        updateNote(activeNoteId, 'updatedAt', getTodayString());
        alert('已儲存筆記！(模擬)');
    }
  };

  const activeNote = notes.find(n => n.id === activeNoteId);

  // 更新筆記內容
  const updateNote = (id, field, value) => {
    setNotes(notes.map(n => n.id === id ? { ...n, [field]: value } : n));
  };

  // --- 登入頁面 ---
  if (!user) {
    return (
      <div className="min-h-screen bg-gray-50 flex flex-col justify-center items-center p-4 font-sans">
        <div className="bg-white p-8 rounded-2xl shadow-xl w-full max-w-md">
          <div className="flex justify-center mb-6">
            <div className="w-16 h-16 bg-blue-600 rounded-2xl flex items-center justify-center text-white">
              <FileText size={32} />
            </div>
          </div>
          <h1 className="text-3xl font-bold text-center text-gray-800 mb-2">MyNote</h1>
          <p className="text-gray-500 text-center mb-8">您的專屬個人筆記空間</p>
          
          <form onSubmit={handleLogin} className="space-y-4">
            <div>
              <label className="block text-sm font-medium text-gray-700 mb-1">帳號</label>
              <input 
                type="text" 
                value={usernameInput}
                onChange={(e) => setUsernameInput(e.target.value)}
                className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500 outline-none transition-all"
                placeholder="請輸入帳號"
              />
            </div>
            <div>
              <label className="block text-sm font-medium text-gray-700 mb-1">密碼</label>
              <input 
                type="password" 
                defaultValue="password"
                className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500 outline-none transition-all"
                placeholder="請輸入密碼"
              />
            </div>
            <button 
              type="submit"
              className="w-full bg-blue-600 hover:bg-blue-700 text-white font-bold py-3 rounded-lg transition-colors flex items-center justify-center gap-2 mt-4"
            >
              登入 <ArrowRight size={18} />
            </button>
          </form>
        </div>
      </div>
    );
  }

  // --- 主介面 ---
  return (
    <div className="flex h-screen bg-gray-100 overflow-hidden font-sans text-gray-800">
      
      {/* List Column (Left) */}
      <div className={`
        w-full md:w-80 border-r border-gray-200 bg-gray-50 flex flex-col h-full
        ${activeNoteId && 'hidden md:flex'} 
      `}>
        {/* Header: 只留 Title 和 Logout */}
        <div className="p-5 border-b border-gray-200 bg-white flex items-center justify-between">
          <h1 className="text-xl font-bold text-gray-800 tracking-tight">MyNote</h1>
          <button 
            onClick={handleLogout}
            className="p-2 text-gray-400 hover:text-red-500 hover:bg-red-50 rounded-lg transition-colors"
            title="登出"
          >
            <LogOut size={20} />
          </button>
        </div>

        {/* Note List */}
        <div className="flex-1 overflow-y-auto p-3 space-y-2">
          {notes.length === 0 ? (
            <div className="text-center text-gray-400 mt-20">
              <FileText size={48} className="mx-auto mb-3 opacity-20" />
              <p>目前沒有筆記</p>
            </div>
          ) : (
            notes.map(note => (
              <div 
                key={note.id}
                onClick={() => setActiveNoteId(note.id)}
                className={`p-4 rounded-xl cursor-pointer transition-all hover:shadow-sm border-2 ${
                  activeNoteId === note.id 
                  ? 'bg-white shadow border-blue-500' 
                  : 'bg-white border-transparent hover:border-gray-200'
                }`}
              >
                <h3 className={`font-bold text-base mb-1 truncate ${activeNoteId === note.id ? 'text-blue-700' : 'text-gray-800'}`}>
                  {note.title || '未命名筆記'}
                </h3>
                <p className="text-xs text-gray-500 line-clamp-2 h-8 mb-3">
                  {note.content || '無內容...'}
                </p>
                
                {/* 雙日期顯示 */}
                <div className="flex flex-col gap-1 border-t border-gray-100 pt-2">
                  <div className="flex items-center text-[10px] text-gray-400">
                    <Calendar size={10} className="mr-1" />
                    <span className="mr-1">建立:</span>
                    <span>{note.createdAt}</span>
                  </div>
                  <div className="flex items-center text-[10px] text-gray-400">
                    <Clock size={10} className="mr-1" />
                    <span className="mr-1">修改:</span>
                    <span>{note.updatedAt}</span>
                  </div>
                </div>
              </div>
            ))
          )}
        </div>

        {/* Footer Actions */}
        <div className="p-4 border-t border-gray-200 bg-white flex items-center gap-2">
          <button 
            onClick={createNote}
            className="flex-1 bg-blue-600 hover:bg-blue-700 text-white py-2.5 px-4 rounded-lg flex items-center justify-center gap-2 transition-colors shadow-lg font-bold"
          >
            <Plus size={18} />
            <span>新增筆記</span>
          </button>
          
          <button 
            onClick={handleDeleteNote}
            className={`p-2.5 rounded-lg border transition-colors ${
               activeNoteId 
               ? 'border-red-200 text-red-500 hover:bg-red-50 hover:border-red-300' 
               : 'border-gray-200 text-gray-300 cursor-not-allowed'
            }`}
            title={activeNoteId ? "刪除目前選中的筆記" : "請先選擇筆記"}
            disabled={!activeNoteId}
          >
            <Trash2 size={20} />
          </button>
        </div>
      </div>

      {/* Editor Column (Right) */}
      <div className={`
        flex-1 flex flex-col bg-white h-full relative
        ${!activeNoteId && 'hidden md:flex'}
      `}>
        {activeNote ? (
          <>
            {/* Editor Toolbar: 移除文字，只留功能鍵 */}
            <div className="h-16 border-b border-gray-100 flex items-center justify-between px-4 md:px-8 shrink-0">
              
              <div className="flex items-center">
                  {/* Mobile Back Button */}
                  <button 
                      onClick={() => setActiveNoteId(null)} 
                      className="md:hidden mr-3 text-gray-500"
                  >
                      <ChevronRight size={24} className="transform rotate-180" />
                  </button>
              </div>

              <button 
                  onClick={handleSave}
                  className="bg-blue-600 hover:bg-blue-700 text-white px-6 py-2 rounded-lg flex items-center gap-2 text-sm font-bold transition-all shadow-md hover:shadow-lg active:scale-95"
              >
                  <Save size={16} />
                  <span>儲存</span>
              </button>
            </div>

            {/* Editor Inputs */}
            <div className="flex-1 overflow-y-auto">
              <div className="max-w-3xl mx-auto px-4 md:px-8 py-8">
                <input
                  type="text"
                  value={activeNote.title}
                  onChange={(e) => updateNote(activeNote.id, 'title', e.target.value)}
                  placeholder="筆記標題"
                  className="w-full text-3xl md:text-4xl font-bold text-gray-800 placeholder-gray-300 border-none outline-none bg-transparent mb-6"
                />
                <textarea
                  value={activeNote.content}
                  onChange={(e) => updateNote(activeNote.id, 'content', e.target.value)}
                  placeholder="開始輸入內容..."
                  className="w-full h-[calc(100vh-250px)] resize-none text-lg leading-relaxed text-gray-700 placeholder-gray-300 border-none outline-none bg-transparent"
                />
              </div>
            </div>
          </>
        ) : (
          // Empty State
          <div className="flex-1 flex flex-col items-center justify-center text-gray-300 bg-white">
            <div className="w-24 h-24 bg-gray-50 rounded-full flex items-center justify-center mb-4">
              <FolderPlus size={40} className="text-gray-300" />
            </div>
            <p className="text-lg font-medium text-gray-400">歡迎使用 MyNote</p>
            <p className="text-sm mt-2 text-gray-400">
               請從左側列表選擇筆記，或建立新筆記。
            </p>
          </div>
        )}
      </div>
    </div>
  );
}