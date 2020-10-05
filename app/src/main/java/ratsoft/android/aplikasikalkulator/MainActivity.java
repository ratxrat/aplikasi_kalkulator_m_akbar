package ratsoft.android.aplikasikalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText input1;
    private EditText input2;
    private TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.nomor1);
        input2 = findViewById(R.id.nomor2);
        total = findViewById(R.id.total);
    }
    //cek untuk desimal atau tidak menghilangkan .0 biar simple dan seperti kalkulator sebenarnya :v
    private  String CekDesimal(float angka){
        String _t ;
        String _a = "" + angka;
        if((angka-(int)angka)!=0) {
            _t = "" + angka;
        }
        else {
            _t = _a.substring(0, _a.length() - 2);
        }
        return _t;

    }
    public void hitung(View view) {
        String tag =  view.getTag().toString();
        float a = Float.parseFloat(input1.getText().toString());
        float b = Float.parseFloat(input2.getText().toString());
        switch (tag) {
            case "tambah": {
                float hasil = a + b;
                total.setText(getString(R.string.jumlah, "" + CekDesimal(hasil)));
                break;
            }
            case "kurang": {
                float hasil = a - b;
                total.setText(getString(R.string.jumlah, "" + CekDesimal(hasil)));
                break;
            }
            case "kali": {
                float hasil = a * b;
                total.setText(getString(R.string.jumlah, "" + CekDesimal(hasil)));
                break;
            }
            case "bagi": {
                float hasil = a / b;
                total.setText(getString(R.string.jumlah, "" + CekDesimal(hasil)));
                break;
            }
        }
    }

    public void bersih(View view) {
        input1.setText(getString(R.string.kosong));
        input2.setText(getString(R.string.kosong));
        total.setText(getString(R.string.nol));
    }
}