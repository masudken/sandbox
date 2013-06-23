package jp.co.gfam.gits.business;

/**
 * この例外は、システムで致命的なエラーが発生した場合にスローされます。
 *
 * @author Kenichi Masuda
 */
public class SystemException extends RuntimeException {

    /**
     * シリアライズVersionID
     */
    private static final long serialVersionUID = -8091248855390985106L;

    /**
     * 詳細メッセージを持たない {@code SystemException} を構築します。
     */
    public SystemException() {
    }

    /**
     * 指定された詳細メッセージを持つ {@code SystemException} を構築します。
     *
     * @param message 詳細メッセージ
     */
    public SystemException(String message) {
        super(message);
    }
}
