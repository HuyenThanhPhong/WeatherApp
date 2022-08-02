package com.example.demoquanlichamcong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.adapter.ChamCongAdapter;
import com.example.model.ChamCong;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtDay, edtSL;
    Spinner spCongNhan, spSanPham;
    Button btnThem, btnXoa, btnSua, btnThoat;
    ListView lvThongtin;

    ArrayList cn= new ArrayList();
    ArrayList sp= new ArrayList();
    ArrayList<ChamCong> dsChamCong = new ArrayList<>();
    ChamCongAdapter chamCongAdapter;

    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void setControl() {
        edtDay = findViewById(R.id.edtDay);
        edtSL = findViewById(R.id.edtSL);
        spCongNhan = findViewById(R.id.spCongNhan);
        spSanPham= findViewById(R.id.spSanPham);
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        btnThoat = findViewById(R.id.btnThoat);
        lvThongtin = findViewById(R.id.lvThongTin);
    }

    private void setEvent() {
        xulySpinnerCN();
        xulySpinnerSP();
        xulyListView();
        xuLyThem();
        xuLyXoa();
        xuLySua();
        xuLyThoat();
    }


    private void xulySpinnerCN() {
        cn.add("Công nhân 1");
        cn.add("Công nhân 2");
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, cn);
        spCongNhan.setAdapter(adapter);
    }

    private void xulySpinnerSP() {
        sp.add("Sản phẩm 1");
        sp.add("Sản phẩm 2");
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, sp);
        spSanPham.setAdapter(adapter);
    }

    private void xulyListView() {
        chamCongAdapter = new StationaryAdapter(MainActivity.this, R.layout.item, dsChamCong);
        lvThongtin.setAdapter(chamCongAdapter);

        lvThongtin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index = position;
                edtDay.setText(dsChamCong.get(position).getDay());
                edtSL.setText(dsChamCong.get(position).getSl());
                spCongNhan.setSelection(cn.indexOf(dsChamCong.get(position).getCn()));
                spSanPham.setSelection(sp.indexOf(dsChamCong.get(position).getSp()));
            }
        });

        lvThongtin.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dsChamCong.remove(position);
                chamCongAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    private void xuLyThem() {
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                if (edtDay.getText().toString().equals("")) {
                    edtDay.setError("Phải nhập ngày!");
                    edtDay.requestFocus();
                    return;
                }

                ChamCong cc = new ChamCong();
                cc.setDay(edtDay.getText().toString().trim());
                cc.setSl(edtSL.getText().toString().trim());
                cc.setCn(spCongNhan.getSelectedItem().toString());
                cc.setSp(spSanPham.getSelectedItem().toString());
                dsChamCong.add(cc);

                chamCongAdapter.notifyDataSetChanged();
            }
        });
    }

    private void xuLyXoa() {
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index != -1 && dsChamCong.isEmpty()) {
                    return;
                }
                dsChamCong.remove(index);

                chamCongAdapter.notifyDataSetChanged();
            }
        });
    }

    private void xuLySua() {
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChamCong cc = dsChamCong.get(index);
                cc.setDay(edtDay.getText().toString().trim());
                cc.setSl(edtSL.getText().toString().trim());
                cc.setCn(spCongNhan.getSelectedItem().toString());
                cc.setSp(spSanPham.getSelectedItem().toString());

                chamCongAdapter.notifyDataSetChanged();
            }
        });
    }

    private void xuLyThoat() {
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
