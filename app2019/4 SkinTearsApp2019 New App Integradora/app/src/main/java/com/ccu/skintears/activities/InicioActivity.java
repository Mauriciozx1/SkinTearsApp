package com.ccu.skintears.activities;

import android.os.Bundle;

import com.ccu.skintears.R;
import com.ccu.skintears.activities.base.AbstractDrawerActivity;

public class InicioActivity extends AbstractDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_inicio;
    }

    @Override
    public String getCustomTitle() {
        return this.getClass().getSimpleName();
    }
}
