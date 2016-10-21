package com.forezp.banya.adapter;

import android.app.Service;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forezp.banya.BR;
import com.forezp.banya.R;
import com.forezp.banya.bean.top250.Root;
import com.forezp.banya.bean.top250.Subjects;
import com.forezp.banya.binding.BindingViewHolder;

/**
 * Created by forezp on 16/9/25.
 */
public class Top250FilmAdapter extends RecyclerView.Adapter<BindingViewHolder> {
    private Root root;
    private LayoutInflater mLayoutInflater;
    private Context context;
    private int status = 1;
    public static final int LOAD_MORE = 0;
    public static final int LOAD_PULL_TO = 1;
    public static final int LOAD_NONE = 2;
    public static final int LOAD_END = 3;
    private static final int TYPE_TOP = -1;
    private static final int TYPE_FOOTER = -2;
    private OnItemClickListener mListener;

    public Top250FilmAdapter(Context context, Root root) {
        this.context = context;
        this.mLayoutInflater = (LayoutInflater) context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
        this.root = root;
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return position;
        }
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding;
        if (viewType == TYPE_FOOTER) {
            binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.activity_view_footer, null, false);
        } else {
            binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_film_us, null, false);
        }
        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        final Subjects subjects = root.getSubjects().get(position);
        subjects.setPosition(position);
        holder.getBinding().setVariable(BR.item, subjects);
        holder.getBinding().executePendingBindings();
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    if (getItemViewType(position) != TYPE_FOOTER) {
                        mListener.onSubjectsClick(subjects);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return root.getSubjects().size() + 1;
    }

    public void setListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public interface OnItemClickListener {
        void onSubjectsClick(Subjects subjects);
    }

    /**
     * footer view
     */
//    class FooterViewHolder extends BindingViewHolder {
//        @BindView(R.id.tv_load_prompt)
//        TextView tv_load_prompt;
//        @BindView(R.id.progress)
//        ProgressBar progress;
//
//        public FooterViewHolder(View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//            LinearLayoutCompat.LayoutParams params = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ScreenUtils.dipToPx(context, 40));
//            itemView.setLayoutParams(params);
//        }
//
//        private void bindItem() {
//            switch (status) {
//                case LOAD_MORE:
//                    progress.setVisibility(View.VISIBLE);
//                    tv_load_prompt.setText("正在加载...");
//                    itemView.setVisibility(View.VISIBLE);
//                    break;
//                case LOAD_PULL_TO:
//                    progress.setVisibility(View.GONE);
//                    tv_load_prompt.setText("上拉加载更多");
//                    itemView.setVisibility(View.VISIBLE);
//                    break;
//                case LOAD_NONE:
//                    System.out.println("LOAD_NONE----");
//                    progress.setVisibility(View.GONE);
//                    tv_load_prompt.setText("已无更多加载");
//                    break;
//                case LOAD_END:
//                    itemView.setVisibility(View.GONE);
//                default:
//                    break;
//            }
//        }
//    }

    public void updateLoadStatus(int status) {
        this.status = status;
        notifyDataSetChanged();
    }
}
