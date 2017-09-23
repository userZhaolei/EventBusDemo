package zl.com.eventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onMain(AnyEvent event) {
        btn.setText("name:" + event.getString() + " id" + event.getId() + "这是主线程");
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onMe(AnyEvent event) {
        btn.setText("name:" + event.getString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
          EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(this);
    }
}
