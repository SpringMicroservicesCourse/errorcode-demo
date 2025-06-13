package tw.fengqing.spring.data.demo.exception;

import org.springframework.dao.DuplicateKeyException;

/**
 * 自定義重複鍵值異常類別
 * 
 * 此類別用於處理資料庫操作時發生的重複鍵值錯誤。
 * 繼承自 Spring 的 DuplicateKeyException，提供更明確的錯誤處理機制。
 * 
 * @author fengqing
 * @version 1.0
 */
public class CustomDuplicatedKeyException extends DuplicateKeyException {
    
    /**
     * 建構子 - 僅包含錯誤訊息
     * 
     * @param msg 錯誤訊息，描述重複鍵值的具體情況
     */
    public CustomDuplicatedKeyException(String msg) {
        super(msg);
    }

    /**
     * 建構子 - 包含錯誤訊息和原始異常
     * 
     * @param msg 錯誤訊息，描述重複鍵值的具體情況
     * @param cause 原始異常，用於追蹤錯誤的根源
     */
    public CustomDuplicatedKeyException(String msg, Throwable cause) {
        super(msg, cause);
    }
} 