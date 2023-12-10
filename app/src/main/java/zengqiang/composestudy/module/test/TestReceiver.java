package zengqiang.composestudy.module.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.json.JSONObject;

/**
 * @author 李增强
 * @date 2023/07/21  13:28
 * @Copyright Shanghai Yejia Digital Technology Co., Ltd.
 */
public class TestReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                JSONObject jsonObject = new JSONObject(intent.getStringExtra("data"));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
