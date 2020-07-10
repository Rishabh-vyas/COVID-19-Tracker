package com.example.covid_19tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyCustomAdapter extends ArrayAdapter<CountryModle> {

    private Context context;
    private List<CountryModle> countryModlesList;
    private List<CountryModle> countryModlesListFilter;

    public MyCustomAdapter(Context context, List<CountryModle>countryModlesList ) {
        super(context, R.layout.list_custom_items,countryModlesList);
        this.context=context;
        this.countryModlesList=countryModlesList;
        this.countryModlesListFilter=countryModlesList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom_items,null,true);
        TextView tvCounrtyName=view.findViewById(R.id.tvCounryName);
        ImageView imageView=view.findViewById(R.id.imageFalg);

        tvCounrtyName.setText(countryModlesListFilter.get(position).getCountry());
        Glide.with(context).load(countryModlesListFilter.get(position).getFlag()).into(imageView);

        return view;
    }

    @Override
    public int getCount() {

        return countryModlesListFilter.size();
    }

    @Nullable
    @Override
    public CountryModle getItem(int position) {
        return countryModlesListFilter.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();
                if(constraint == null || constraint.length() == 0){
                    filterResults.count = countryModlesList.size();
                    filterResults.values = countryModlesList;

                }else{
                    List<CountryModle> resultsModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();

                    for(CountryModle itemsModel:countryModlesList){
                        if(itemsModel.getCountry().toLowerCase().contains(searchStr)){
                            resultsModel.add(itemsModel);

                        }
                        filterResults.count = resultsModel.size();
                        filterResults.values = resultsModel;
                    }


                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                countryModlesListFilter = (List<CountryModle>) results.values;
                AffectedCountries.countryModleList= (List<CountryModle>) results.values;
                notifyDataSetChanged();

            }
        };
        return filter;
    }
}
