package com.example.android.newsfeedandrecyclerview;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

//public class MainActivity extends AppCompatActivity
//        implements LoaderManager.LoaderCallbacks<List<News>> {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private NewsAdapter adapter;
    private List<News> newsList;

    /**
     * TextView that is displayed when the list is empty
     */
    private TextView mEmptyStateTextView;

    /**
     * URL for news data from the the Guardian dataset
     */
    private static final String GUARDIAN_REQUEST_URL =
            "http://content.guardianapis.com/search?q=bitcoin&api-key=test&show-tags=contributor";

    /**
     * Constant value for the news loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    private static final int News_LOADER_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initCollapsingToolbar();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

//        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
//        recyclerView.setEmptyView(mEmptyStateTextView);


        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);


        newsList = new ArrayList<>();
        adapter = new NewsAdapter(this, newsList);

//
//            // TODO: Set an item click listener, which sends an intent to a web browse
//            // to open a website with more information
//            @Override public void onItemClick(News news) {
//                String url = news.getUrl();
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//            }
//        };

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        try {
            Glide.with(this).load(R.drawable.bitcoin).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    /**
     * Adding few albums for testing
     */

    private void prepareAlbums() {

        News a = new News("True Romance", "dsfasdf", "asfsd", "sdfasdf", "sadfaadfs");
        newsList.add(a);

        a = new News("True Beast", "jhkhgjk", "asfhgjkghjksd", "sdfasdf", "sadfaadfs");
        newsList.add(a);

        a = new News("True Love", "bnvmvbnm", "asfsd", "sdfasdf", "sadfaadfs");
        newsList.add(a);

        a = new News("True Hate", "iopüiopüiop", "asfsd", "sdfasdf", "sadfaadfs");
        newsList.add(a);

        a = new News("True Beast", "jhkhgjk", "asfhgjkghjksd", "sdfasdf", "sadfaadfs");
        newsList.add(a);

        a = new News("True Love", "bnvmvbnm", "asfsd", "sdfasdf", "sadfaadfs");
        newsList.add(a);

        a = new News("True Hate", "iopüiopüiop", "asfsd", "sdfasdf", "sadfaadfs");
        newsList.add(a);

        a = new News("True Beast", "jhkhgjk", "asfhgjkghjksd", "sdfasdf", "sadfaadfs");
        newsList.add(a);

        a = new News("True Love", "bnvmvbnm", "asfsd", "sdfasdf", "sadfaadfs");
        newsList.add(a);

        a = new News("True Hate", "iopüiopüiop", "asfsd", "sdfasdf", "sadfaadfs");
        newsList.add(a);

        a = new News("True Beast", "jhkhgjk", "asfhgjkghjksd", "sdfasdf", "sadfaadfs");
        newsList.add(a);

        a = new News("True Love", "bnvmvbnm", "asfsd", "sdfasdf", "sadfaadfs");
        newsList.add(a);

        a = new News("True Hate", "iopüiopüiop", "asfsd", "sdfasdf", "sadfaadfs");
        newsList.add(a);

        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

//    @Override
//    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {
//        // Create a new loader for the given URL
//        return new NewsLoader(this, GUARDIAN_REQUEST_URL);
//    }
//
//    @Override
//    public void onLoadFinished(Loader<List<News>> loader, List<News> news) {
//        // Hide loading indicator because the data has been loaded
//        View loadingIndicator = findViewById(R.id.loading_indicator);
//        loadingIndicator.setVisibility(View.GONE);
//
//        // Set empty state text to display "No news found."
//        mEmptyStateTextView.setText(R.string.no_news);
//
//        // Clear the adapter of previous news data
//        adapter.clear();
//
//        // If there is a valid list of {@link News}s, then add them to the adapter's
//        // data set. This will trigger the ListView to update.
//        if (news != null && !news.isEmpty()) {
//            adapter.addAll(news);
//        }
//    }
//
//    @Override
//    public void onLoaderReset(Loader<List<News>> loader) {
//        // Loader reset, so we can clear out our existing data.
//        adapter.clear();
//    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
