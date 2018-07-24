package com.moneytap.feature.wikipediasearch;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.moneytap.model.WikipediaPage;
import com.moneytap.wikipediasearch.R;
import java.util.List;

/**
 * Created by Sai on 22/07/18.
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchItemViewHolder> {

  private List<WikipediaPage> wikiPages;
  private SearchContract.SearchPresenter presenter;

  public SearchAdapter(List<WikipediaPage> list, SearchContract.SearchPresenter presenter) {
    this.wikiPages = list;
    this.presenter = presenter;
  }

  @NonNull @Override
  public SearchItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
      int viewType) {
    return SearchItemViewHolder.create(parent);
  }

  @Override
  public void onBindViewHolder(@NonNull SearchItemViewHolder holder, int position) {
    holder.bind(wikiPages.get(position), presenter);
  }

  @Override public int getItemCount() {
    return wikiPages.size();
  }

  static class SearchItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_thumbnail) ImageView ivThumbnail;
    @BindView(R.id.tv_description) TextView tvDescription;
    @BindView(R.id.tv_title) TextView tvTitle;


    public SearchItemViewHolder(View itemView) {
      super(itemView);
    }

    public static SearchItemViewHolder create(ViewGroup parent) {
      View view =
          LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);
      return new SearchItemViewHolder(view);
    }

    public void bind(final WikipediaPage page, final SearchContract.SearchPresenter searchPresenter) {
      ButterKnife.bind(this, itemView);
      if (page.getTerms() != null && page.getTerms().getDescription() != null && !page.getTerms()
          .getDescription()
          .isEmpty()) {
        tvDescription.setText(page.getTerms().getDescription().get(0));
      }
      tvTitle.setText(page.getTitle());
      if (page.getThumbnail() != null) {
        Glide.with(ivThumbnail.getContext())
            .load(page.getThumbnail().getSource())
            .into(ivThumbnail);
      }

      itemView.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          searchPresenter.fetchUrlForPage(page.getPageid());
        }
      });
    }
  }
}
