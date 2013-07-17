package jp.co.gfam.gits.presantation.action;

import java.sql.Connection;
import java.util.Map;

import jp.co.gfam.gits.common.connection.ConnectionContext;
import jp.co.gfam.gits.common.connection.ConnectionManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

/**
 * このクラスはホーム画面表示用のアクションクラスです。
 *
 * @author Kenichi Masuda
 */
public class HomeAction implements SessionAware {

    @Override
    public void setSession(Map<String, Object> session) {
        // TODO 自動生成されたメソッド・スタブ
    }

    /**
     * このアクションを実行します。
     *
     * @return
     * @throws Exception
     */
    @Action(value = "/home", results = { @Result(name = "success",
            location = "issue_list.jsp") })
    public String execute() throws Exception {

        // TODO プロキシ作って移動するか？
        // コネクションの取得とトランザクションの開始
        Connection connection = ConnectionManager.getInstance()
                .openConnection();
        connection.setAutoCommit(false);
        ConnectionContext.getContext().SetConnection(connection);

        // サービスの実行
        //service.authenticate(_userName, _password);

        // トランザクションのコミット
        connection.commit();

        // 画面遷移
        return "success";
    }
}
