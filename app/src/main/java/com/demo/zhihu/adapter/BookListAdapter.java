package com.demo.zhihu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.demo.zhihu.R;
import com.demo.zhihu.bean.HomeBean;

import java.util.List;


public class BookListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_EMPTY = 0;
    private static final int TYPE_DEFAULT = 1;
    private  List<HomeBean.data> bookInfoResponses;
    private Context mContext;

    public BookListAdapter(Context context) {

        this.mContext = context;
    }

    public  void setData(List<HomeBean.data> responses){
        this.bookInfoResponses = responses;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_DEFAULT) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_list, parent, false);
            return new BookListHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty, parent, false);
            return new EmptyHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (bookInfoResponses == null || bookInfoResponses.isEmpty()) {
            return TYPE_EMPTY;
        } else {
            return TYPE_DEFAULT;
        }
    }



    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BookListHolder) {
            final HomeBean.data bookInfo = bookInfoResponses.get(position);
            Glide.with(mContext)
                    .load("http://118.25.37.196:8080/"+bookInfo.getCoverImage())
                    .into(((BookListHolder) holder).iv_book_img);
            ((BookListHolder) holder).tv_book_title.setText(bookInfo.getTitle());
//            ((BookListHolder) holder).tv_hots_num.setText(bookInfo.getRating().getAverage());
            ((BookListHolder) holder).tv_book_info.setText(bookInfo.getIntroduction());
            ((BookListHolder) holder).tv_book_description.setText(bookInfo.getIntroduction());
            ((BookListHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Bundle b = new Bundle();
//                    b.putSerializable(BookInfoResponse.serialVersionName, bookInfo);
//                    Bitmap bitmap;
//                    GlideBitmapDrawable imageDrawable = (GlideBitmapDrawable) ((BookListHolder) holder).iv_book_img.getDrawable();
//                    if (imageDrawable != null) {
//                        bitmap = imageDrawable.getBitmap();
//                        b.putParcelable("book_img", bitmap);
//                    }
//                    Intent intent = new Intent(UIUtils.getContext(), BookDetailActivity.class);
//                    intent.putExtras(b);
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                        if (BaseActivity.activity == null) {
//                            UIUtils.startActivity(intent);
//                            return;
//                        }
//                        ActivityOptionsCompat options = ActivityOptionsCompat.
//                                makeSceneTransitionAnimation(BaseActivity.activity, ((BookListHolder) holder).iv_book_img, "book_img");
//                        BaseActivity.activity.startActivity(intent, options.toBundle());
//                    } else {
//                        UIUtils.startActivity(intent);
//                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (bookInfoResponses==null) {
            return 1;
        }
        return bookInfoResponses.size();
    }

    class BookListHolder extends RecyclerView.ViewHolder {

        private final ImageView iv_book_img;
        private final TextView tv_book_title;
     //   private final AppCompatRatingBar ratingBar_hots;
        private final TextView tv_hots_num;
        private final TextView tv_book_info;
        private final TextView tv_book_description;

        public BookListHolder(View itemView) {
            super(itemView);
            iv_book_img = (ImageView) itemView.findViewById(R.id.iv_book_img);
            tv_book_title = (TextView) itemView.findViewById(R.id.tv_book_title);
           // ratingBar_hots = (AppCompatRatingBar) itemView.findViewById(R.id.ratingBar_hots);
            tv_hots_num = (TextView) itemView.findViewById(R.id.tv_hots_num);
            tv_book_info = (TextView) itemView.findViewById(R.id.tv_book_info);
            tv_book_description = (TextView) itemView.findViewById(R.id.tv_book_description);
        }
    }

    class EmptyHolder extends RecyclerView.ViewHolder {
        public EmptyHolder(View itemView) {
            super(itemView);
        }
    }
}
