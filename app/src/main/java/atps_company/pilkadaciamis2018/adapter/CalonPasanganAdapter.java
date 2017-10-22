package atps_company.pilkadaciamis2018.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import atps_company.pilkadaciamis2018.R;
import atps_company.pilkadaciamis2018.model.CalonPasangan;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by emerio on 4/9/17.
 */

public class CalonPasanganAdapter extends RecyclerView.Adapter<CalonPasanganAdapter.CalonPasanganHolder> {
    private List<CalonPasangan> CalonPasanganList;
    private CalonPasanganAdapterCallback mCallback;

    @Inject
    public CalonPasanganAdapter() {
        CalonPasanganList = new ArrayList<>();
    }
    public void setCalonPasangan(List<CalonPasangan> listCalonPasangan) {
        this.CalonPasanganList.addAll(listCalonPasangan);
    }
    @Override
    public CalonPasanganHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_view_item_layout,
                parent, false);
        return new CalonPasanganHolder(view);
    }

    @Override
    public void onBindViewHolder(CalonPasanganHolder holder, int position) {
        CalonPasangan CalonPasangan = CalonPasanganList.get(position);
        holder.setCalonPasangan(CalonPasangan);
        holder.noUrut.setText(CalonPasangan.getNama() );

    }
   private void simpleDateFormat(String date){

   }
    public void setCallback(CalonPasanganAdapterCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public int getItemCount() {
        return CalonPasanganList.size();
    }

    class CalonPasanganHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.nourut)
        TextView noUrut;
        @BindView(R.id.image)
        ImageView thumbnail;

        CalonPasangan calonPasangan;

        public CalonPasanganHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        public void setCalonPasangan(CalonPasangan CalonPasangan) {
            this.calonPasangan = CalonPasangan;
        }
        @OnClick(R.id.row_layout)
        void onItemClicked(View view) {
            Log.d("test","test");
            if (mCallback != null) mCallback.onCalonPasanganClicked(calonPasangan);
        }
    }

    public static interface CalonPasanganAdapterCallback {
        public void onCalonPasanganClicked(CalonPasangan calonPasangan);
    }
}
