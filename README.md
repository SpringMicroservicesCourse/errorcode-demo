# Spring Boot 錯誤碼處理示範專案

## 專案簡介
本專案為 Spring Boot 錯誤碼處理的示範專案，主要展示如何在微服務架構中處理資料庫重複鍵值（Duplicate Key）的錯誤情況。透過自定義異常處理機制，提供更清晰的錯誤訊息和更好的使用者體驗。

## 相關資源
- [Spring 官方錯誤碼定義](https://github.com/spring-projects/spring-framework/blob/main/spring-jdbc/src/main/resources/org/springframework/jdbc/support/sql-error-codes.xml)

## 技術規格
- 開發語言：Java 21
- 框架版本：Spring Boot 3.4.5
- 資料庫存取：Spring JDBC
- 記憶體資料庫：H2 Database
- 開發工具：Lombok

## 系統需求
- JDK 21 或以上版本
- Maven 3.6 或以上版本

## 快速開始
### 前置準備
1. 確認已安裝 JDK 21
```bash
java -version
```

2. 確認已安裝 Maven
```bash
mvn -version
```

### 安裝步驟
1. 複製專案到本地端
```bash
git clone [專案網址]
```

2. 進入專案目錄
```bash
cd errorcode-demo
```

3. 使用 Maven 編譯專案
```bash
mvn clean install
```

4. 啟動應用程式
```bash
mvn spring-boot:run
```

## 專案架構
```
src/main/java/tw/fengqing/spring/data/demo/
├── exception/                           # 異常處理相關類別
│   └── CustomDuplicatedKeyException.java  # 自定義重複鍵值異常類別
└── ErrorCodeDemoApplication.java        # 應用程式主程式
```

## 核心功能說明
### 自定義重複鍵值異常處理
本專案實作了自定義的異常處理機制，主要用於處理資料庫操作時可能發生的重複鍵值錯誤：

- `CustomDuplicatedKeyException` 類別
  - 繼承自 Spring 的 `DuplicateKeyException`
  - 提供兩種建構方法：
    - 基本建構方法：僅包含錯誤訊息
    - 進階建構方法：包含錯誤訊息和原始異常資訊

## 使用說明
### 異常處理方式
1. 在需要處理重複鍵值異常的地方，使用以下方式拋出異常：
```java
throw new CustomDuplicatedKeyException("資料重複：使用者帳號已存在");
```

2. 若需要包含原始異常資訊：
```java
throw new CustomDuplicatedKeyException("資料重複：使用者帳號已存在", originalException);
```

### 異常處理建議
- 建議在 Service 層進行異常處理
- 記錄詳細的錯誤日誌
- 提供友善的使用者錯誤訊息

## 開發注意事項
1. 資料庫相關
   - 開發環境使用 H2 記憶體資料庫
   - 正式環境需調整資料庫連線設定
   - 建議實作資料庫連線池

2. 效能考量
   - 注意資料庫索引設計
   - 避免大量資料的重複檢查
   - 實作適當的快取機制

3. 安全性考量
   - 避免在錯誤訊息中暴露敏感資訊
   - 實作適當的存取控制
   - 定期更新相依套件版本
