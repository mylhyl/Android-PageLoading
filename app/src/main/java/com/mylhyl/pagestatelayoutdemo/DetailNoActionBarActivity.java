package com.mylhyl.pagestatelayoutdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.mylhyl.pagestatelayout.PageState;
import com.mylhyl.pagestatelayout.PageStateLayout;

public class DetailNoActionBarActivity extends AppCompatActivity {

    private PageState mPageState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_no_action_bar);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        mPageState = PageStateLayout.wrap(this, R.id.psl_content);
        ImageView emptyImgView = mPageState.getEmptyImgView();
        emptyImgView.setImageResource(R.mipmap.ic_push_msg_empty);

        ImageView errorImgView =  mPageState.getErrorImgView();
        errorImgView.setImageResource(R.mipmap.ic_pager_invalid);

        ImageView errorNetImgView = mPageState.getErrorNetImgView();
        errorNetImgView.setImageResource(R.mipmap.ic_network_invalid);
        mPageState.showLoadingView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.findItem(R.id.menu_codeAct).setVisible(false);
        menu.findItem(R.id.menu_customEmpty).setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_loading:
                mPageState.showLoadingView();
                break;
            case R.id.menu_empty:
                mPageState.showEmptyView();
                break;
            case R.id.menu_error:
                mPageState.showErrorView();
                break;
            case R.id.menu_errorNet:
                mPageState.showErrorNetView();
                break;
            case R.id.menu_content:
                mPageState.showContentView();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
