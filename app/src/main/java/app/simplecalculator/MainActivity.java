package app.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et_first_number, et_second_number;
    ImageView iv_add, iv_minus, iv_multiple;
    TextView tv_result_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListener();
    }

    private void initViews() {
        et_first_number = findViewById(R.id.et_first_number);
        et_second_number = findViewById(R.id.et_second_number);
        iv_add = findViewById(R.id.iv_add);
        iv_minus = findViewById(R.id.iv_minus);
        iv_multiple = findViewById(R.id.iv_multiple);
        tv_result_value = findViewById(R.id.tv_result_value);
    }

    private void initListener() {
        iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumbers();
            }
        });

        iv_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minusNumbers();
            }
        });

        iv_multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multipleNumbers();
            }
        });
    }

    private void addNumbers() {
        try {
            tv_result_value.setText(String.valueOf(getFirstNumber() + getSecondNumber()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void minusNumbers() {
        try {
            tv_result_value.setText(String.valueOf(getFirstNumber() - getSecondNumber()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void multipleNumbers() {
        try {
            tv_result_value.setText(String.valueOf(getFirstNumber() * getSecondNumber()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private long getFirstNumber() {
        try {
            String firstNumberString = et_first_number.getText().toString();
            if (TextUtils.isEmpty(firstNumberString)) {
                et_first_number.setError("Empty");
            } else {
                return Long.parseLong(firstNumberString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private long getSecondNumber() {
        try {
            String secondNumberString = et_second_number.getText().toString();
            if (TextUtils.isEmpty(secondNumberString)) {
                et_second_number.setError("Empty");
            } else {
                return Long.parseLong(secondNumberString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}