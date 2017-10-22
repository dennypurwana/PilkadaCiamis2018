package atps_company.pilkadaciamis2018.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import atps_company.pilkadaciamis2018.R;
import atps_company.pilkadaciamis2018.model.CalonPasangan;


public class GridAdapter extends RecyclerView.Adapter<GridAdapter.CalonPasanganHolder> {

    private List<CalonPasangan> calonPasanganList;
    private int rowLayout;
    private Context context;

    static class CalonPasanganHolder extends RecyclerView.ViewHolder {
        TextView nourut;
        ImageView thumbnail;

        CalonPasanganHolder(View v) {
            super(v);
            nourut = (TextView) v.findViewById(R.id.nourut);
            thumbnail = (ImageView) v.findViewById(R.id.image);
        }
    }

    public GridAdapter(List<CalonPasangan> calonPasanganList, int rowLayout, Context context) {
        this.calonPasanganList = calonPasanganList;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public GridAdapter.CalonPasanganHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new CalonPasanganHolder(view);
    }

    @Override
    public void onBindViewHolder(CalonPasanganHolder holder, final int position) {
        try {

            holder.nourut.setText("No Urut "+calonPasanganList.get(position).getNourut());
            } catch (NullPointerException e) {

        }
    }

    @Override
    public int getItemCount() {
        return calonPasanganList.size();
    }
}
