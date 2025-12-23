-- --------------------------------------------------------
-- 主機:                           127.0.0.1
-- 伺服器版本:                        8.0.43 - MySQL Community Server - GPL
-- 伺服器作業系統:                      Win64
-- HeidiSQL 版本:                  12.13.0.7147
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 傾印 mynote 的資料庫結構
CREATE DATABASE IF NOT EXISTS `mynote` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mynote`;

-- 傾印  資料表 mynote.notes 結構
CREATE TABLE IF NOT EXISTS `notes` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '流水號',
  `user_id` int unsigned NOT NULL COMMENT '使用者ID',
  `title` varchar(27) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '無標題筆記' COMMENT '標題',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '內文',
  `created_at` date NOT NULL COMMENT '建立日期',
  `updated_at` date NOT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在傾印表格  mynote.notes 的資料：~5 rows (近似值)
INSERT INTO `notes` (`id`, `user_id`, `title`, `content`, `created_at`, `updated_at`) VALUES
	(1, 1, '這篇標題剛好是二十七個字，是標題文字的上限更多無法添加', 'Java是一種廣泛使用的電腦程式設計語言，擁有跨平台、物件導向、泛型程式設計的特性，廣泛應用於企業級Web應用開發和行動應用開發。\n\n任職於昇陽電腦的詹姆斯·高斯林等人於1990年代初開發Java語言的雛形，最初被命名為Oak，目標設定在家用電器等小型系統的程式語言，應用在電視機、電話、鬧鐘、烤麵包機等家用電器的控制和通訊。由於這些智慧型家電的市場需求沒有預期的高，昇陽電腦放棄了該項計劃。隨著1990年代網際網路的發展，昇陽電腦看見Oak在網際網路上應用的前景，於是改造了Oak，於1995年5月以Java的名稱正式釋出。Java伴隨著網際網路的迅猛發展而發展，逐漸成為重要的網路程式語言。\n\nJava程式語言的風格十分接近C++語言。繼承了C++語言物件導向技術的核心，捨棄了容易引起錯誤的指標，以參照取代；移除了C++中的運算子重載和多重繼承特性，用介面取代；增加垃圾回收器功能。在Java SE 1.5版本中引入了泛型程式設計、類型安全的列舉、不定長參數和自動裝/拆箱特性。昇陽電腦對Java語言的解釋是：「Java程式語言是個簡單、物件導向、分散式、解釋性、健壯、安全、與系統無關、可移植、高效能、多執行緒和動態的語言」。\n\nJava不同於一般的編譯語言或直譯語言。它首先將原始碼編譯成位元組碼，再依賴各種不同平台上的虛擬機器來解釋執行位元組碼，從而具有「一次編寫，到處執行」的跨平台特性。在早期JVM中，這在一定程度上降低了Java程式的執行效率。但在J2SE1.4.2釋出後，Java的執行速度有了大幅提升。\n\n與傳統型態不同，昇陽電腦在推出Java時就將其作為開放的技術。全球的Java開發公司被要求所設計的Java軟體必須相容。「Java語言靠群體的力量而非公司的力量」是昇陽電腦的口號之一，並獲得了廣大軟體開發商的認同。這與微軟公司所倡導的注重精英和封閉式的模式完全不同，此外，微軟公司後來推出了與之競爭的.NET平台以及模仿Java的C#語言。後來昇陽電腦被甲骨文公司併購[14]，Java也隨之成為甲骨文公司的產品。\n\n目前，行動作業系統Android大部分的代碼採用Java程式設計語言編程。', '2025-12-10', '2025-12-14'),
	(2, 2, 'ichieh的筆記', 'ichieh的個人筆記', '2025-12-11', '2025-12-11'),
	(3, 1, '修改日期-示範', '示範修改日期更新', '2025-12-10', '2025-12-10'),
	(4, 1, '刪除筆記-示範', '', '2025-12-14', '2025-12-14'),
	(5, 1, 'MyNote展示', 'MyNote筆記依建立日期順序排列，使用者於內文輸入的內容儲存後更新於左側清單，並自動更新修改日期。', '2025-12-17', '2025-12-17');

-- 傾印  資料表 mynote.users 結構
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '自動遞增主鍵',
  `account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '帳號唯一',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密碼（明碼，僅測試用）',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在傾印表格  mynote.users 的資料：~2 rows (近似值)
INSERT INTO `users` (`user_id`, `account`, `password`) VALUES
	(1, 'coral', '12345678'),
	(2, 'ichieh', '87654321');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
