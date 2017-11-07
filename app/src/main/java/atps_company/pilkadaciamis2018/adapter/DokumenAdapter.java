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
import atps_company.pilkadaciamis2018.model.Dokumen;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by emerio on 4/9/17.
 */

public class DokumenAdapter extends RecyclerView.Adapter<DokumenAdapter.DokumenHolder> {
    private List<Dokumen> DokumenList;
    private DokumenAdapterCallback mCallback;

    @Inject
    public DokumenAdapter() {
        DokumenList = new ArrayList<>();
    }
    public void setDokumen(List<Dokumen> listDokumen) {
        this.DokumenList.addAll(listDokumen);
    }
    @Override
    public DokumenHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_dokumen,
                parent, false);
        return new DokumenHolder(view);
    }

    @Override
    public void onBindViewHolder(DokumenHolder holder, int position) {
        Dokumen Dokumen = DokumenList.get(position);
        holder.setDokumen(Dokumen);
        holder.fileName.setText(Dokumen.getFileName() );

    }
   private void simpleDateFormat(String date){

   }
    public void setCallback(DokumenAdapterCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public int getItemCount() {
        return DokumenList.size();
    }

    class DokumenHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.fileName)
        TextView fileName;

        Dokumen Dokumen;

        public DokumenHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        public void setDokumen(Dokumen Dokumen) {
            this.Dokumen = Dokumen;
        }
        @OnClick(R.id.row_layout)
        void onItemClicked(View view) {
            Log.d("test","test");
            if (mCallback != null) mCallback.onDokumenClicked(Dokumen);
        }
    }

    public static interface DokumenAdapterCallback {
        public void onDokumenClicked(Dokumen Dokumen);
    }
}
