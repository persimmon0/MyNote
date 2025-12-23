# MyNote(Local Web筆記空間)

本地環境的Web筆記空間📖，提供使用者登入與建立、編輯、刪除筆記；  
筆記依建立日期排序，輸入內容儲存後會同步顯示於左側清單，並更新修改日期。

### 初始化環境
1. 安裝MySQL，匯入 *[mynote.sql](https://github.com/persimmon0/MyNote/blob/main/mynote.sql)* (內含預設使用者與筆記資料)
2. 進入 *[application.properties](https://github.com/persimmon0/MyNote/blob/main/MyNote/src/main/resources/application.properties)* 修改資料庫連線設定(username,password)
3. 執行專案
4. 瀏覽器輸入 `http://localhost:8080/` 進入空間
***
### 專案架構
```
MyNote/
│
├── src/main/java/com/mynote/
│   ├── MyNoteApplication.java             ← 專案主入口，Spring Boot起點  
│
│   ├── controller/                        # 控制層
│   │   ├── HomeController.java            ← 分頁切換管理  
│   │   ├── LoginController.java           ← 登入管理  
│   │   └── NoteController.java            ← 筆記管理    
│
│   ├── service/                           # 服務層
│   │   ├── LoginService.java              ← 登入處理  
│   │   └── NoteService.java               ← 筆記處理  
│
│   ├── model/                             # 資料層(Model+Mapper)
│   │   ├── LoginModel.java                ← 登入資料容器  
│   │   ├── NoteModel.java                 ← 筆記資料容器  
│   │   ├── LoginMapper.java               ← 登入操作資料  
│   │   └── NoteMapper.java                ← 筆記操作資料  
│
├── src/main/resources/
│   ├── mapper/                            # MyBatis SQL語句
│   │   ├── LoginMapper.xml                ← 登入SQL  
│   │   └── NoteMapper.xml                 ← 筆記SQL  
│
│   ├── static/                            # 靜態資源
│   │   ├── tailwind.min.css               ← 前端樣式  
│   │   ├── Inter_18pt-Regular.ttf         ← 字型  
│   │   └── ChenYuluoyan-2.0-Thin.ttf      ← 字型  
│
│   ├── templates/                         # 前端頁面
│   │   ├── login.html                     ← 登入頁  
│   │   └── notes.html                     ← 筆記頁  
│
│   └── application.properties             # 資料庫連線設定  
```
***
### 空間預覽  
登入頁
<img width="1920" height="988" alt="01" src="https://github.com/user-attachments/assets/c2051384-9a6f-4582-a1fd-37b7a1a775d3" />
筆記頁
<img width="1920" height="986" alt="02" src="https://github.com/user-attachments/assets/4a8c8850-b928-4cd3-8b37-6754f6f33be6" />

