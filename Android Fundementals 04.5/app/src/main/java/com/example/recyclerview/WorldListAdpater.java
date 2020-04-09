package com.example.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WorldListAdpater extends RecyclerView.Adapter<WorldListAdpater.WordViewHolder> {
    private static final String LOG_TAG = WorldListAdpater.class.getSimpleName();
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    public WorldListAdpater(Context context, LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.wordlist_item, parent,false);
        Log.d(LOG_TAG, itemView.toString());
        return new WordViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        Log.d(LOG_TAG, holder.toString());
        String currentWord = mWordList.get(position);
        holder.wordItemView.setText(currentWord);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        private final String LOG_TAG = WordViewHolder.class.getSimpleName();
        public final TextView wordItemView;
        final WorldListAdpater mAdapter;

        public WordViewHolder(View itemView, WorldListAdpater adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            Log.d(LOG_TAG, wordItemView.toString());
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            String element = mWordList.get(mPosition);
            mWordList.set(mPosition, "Clicked! " + element);
            mAdapter.notifyDataSetChanged();
        }
    }
}