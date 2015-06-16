package com.arjun.recycler;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toobar);
        setSupportActionBar(toolbar);
        mRecyclerView= (RecyclerView) findViewById(R.id.recycler);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        ArrayList<String> list=new ArrayList<String>();
        list.add("ARjun");
        list.add("Gurung");
        list.add("Tsering");
        list.add("Wongel");
        list.add("Gurung");
        list.add("ARjun");
        list.add("GUrung");
        list.add("ARjun");
        list.add("Gurung");
        list.add("ARjun");
        list.add("Gurung");
        list.add("Tsering");
        list.add("Wongel");
        list.add("Gurung");
        list.add("ARjun");
        list.add("GUrung");
        list.add("ARjun");
        list.add("Gurung");
        list.add("ARjun");
        list.add("Gurung");
        list.add("Tsering");
        list.add("Wongel");
        list.add("Gurung");
        list.add("ARjun");
        list.add("GUrung");
        list.add("ARjun");
        list.add("Gurung");
        mAdapter = new MyAdaptor(list);
        mRecyclerView.setAdapter(mAdapter);

    }



    class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.ViewHolder>{
        ArrayList<String> mData;
        OnItemClickListner mItemClickListener;
        MyAdaptor(ArrayList<String> data){
            this.mData=data;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layout_h_img, viewGroup, false);
            ViewHolder vh=new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
             viewHolder.mTextView.setText(mData.get(i));
            viewHolder.img.setImageResource(R.drawable.ar);
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            // each data item is just a string in this case
            public TextView mTextView;
            public ImageView img;
            public ViewHolder(View v) {
                super(v);
                mTextView = (TextView) v.findViewById(R.id.h_text);
                img= (ImageView) v.findViewById(R.id.h_img);
                v.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(view, getPosition());
                }
                TextView name= (TextView) view.findViewById(R.id.h_text);
                Log.d("Ar",name.getText().toString());
            }
        }




    }
    public interface OnItemClickListner{
        public void onItemClick(View view , int position);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
