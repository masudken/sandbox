package jp.co.gfam.gits.presantation.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ViewHelper {

    private static ViewHelper _instance = null;

    private Map<String, String> _statusMap;
    private Map<String, String> _priorityMap;

    private ViewHelper() {
        _statusMap = new HashMap<String, String>();
        _statusMap.put("01", "起票");
        _statusMap.put("02", "対応中");
        _statusMap.put("03", "対応済");
        _statusMap.put("09", "ペンディング");

        _priorityMap = new HashMap<String, String>();
        _priorityMap.put("1", "低め");
        _priorityMap.put("2", "通常");
        _priorityMap.put("3", "高め");
        _priorityMap.put("4", "緊急");
    }

    public static synchronized ViewHelper getInstance() {
        if (_instance == null) {
            _instance = new ViewHelper();
        }
        return _instance;
    }

    public String convertStatus(String statusCode) {
        return _statusMap.get(statusCode);
    }

    public String convertPriority(String priorityCode) {
        return _priorityMap.get(priorityCode);
    }

    public Map<String, String> getStatusMap() {
        return _statusMap;
    }

    public Map<String, String> getPriorityMap() {
        return _priorityMap;
    }

    public String formatDate(Date date) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
        return sdf1.format(date);
    }
}
