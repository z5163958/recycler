package com.example.nyt;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleAdapter extends RecyclerView.Adapter <ArticleAdapter.UserViewHolder> {
    private String[] ;

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article, parent, false);
        UserViewHolder userViewHolder = new UserViewHolder(view);
        userViewHolder.blah();
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User userAtPosition = user.get(position);
        holder.textView.setText
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView ;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);


        }

        public void blah() {
            articleObject1 = FakeDatabase.getArticleById(1);
            articleObject2 = FakeDatabase.getArticleById(2);

            // Explicit intent on the article item
            article1Layout = findViewById(R.id.article1);
            article1Layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), ArticleDetailActivity.class);
                    intent.putExtra("ArticleID", articleObject1.getArticleID());
                    startActivity(intent);
                }
            });

            article2Layout = findViewById(R.id.article2);
            article2Layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), ArticleDetailActivity.class);
                    intent.putExtra("ArticleID", articleObject2.getArticleID());
                    startActivity(intent);
                }
            });

            TextView headline1 = article1Layout.findViewById(R.id.newsHeadline);
            TextView summary1 = article1Layout.findViewById(R.id.newsDetails);
            headline1.setText(articleObject1.getHeadline());
            summary1.setText(articleObject1.getSummary());

            TextView headline2 = article2Layout.findViewById(R.id.newsHeadline);
            TextView summary2 = article2Layout.findViewById(R.id.newsDetails);
            headline2.setText(articleObject2.getHeadline());
            summary2.setText(articleObject2.getSummary());

            // Just some buttons that change image on click
            bookmarkButton1 = article1Layout.findViewById(R.id.newsSaveButton);
            bookmarkButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "Click1 Registered", Toast.LENGTH_SHORT).show();
                    if (!button1State) {
                        bookmarkButton1.setImageResource(R.drawable.ic_bookmark_black_24dp);
                    } else {
                        bookmarkButton1.setImageResource(R.drawable.ic_bookmark_border_black_24dp);
                    }

                    button1State = !button1State;
                }
            });

            bookmarkButton2 = article2Layout.findViewById(R.id.newsSaveButton);
            bookmarkButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "Click2 Registered", Toast.LENGTH_SHORT).show();
                    if (!button2State) {
                        bookmarkButton2.setImageResource(R.drawable.ic_bookmark_black_24dp);
                    } else {
                        bookmarkButton2.setImageResource(R.drawable.ic_bookmark_border_black_24dp);
                    }

                    button2State = !button2State;
                }
            });

            // Implicit intent on the share button
            shareButton1 = article1Layout.findViewById(R.id.newsShareButton);
            shareButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT, "Here is a cool article: " +
                            articleObject1.getHeadline());
                    startActivity(intent);
                }
            });

            shareButton2 = article2Layout.findViewById(R.id.newsShareButton);
            shareButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT, "Here is a cool article: " +
                            articleObject2.getHeadline());
                    startActivity(intent);
                }
            });
        }
        }
    }

}
