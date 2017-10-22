package atps_company.pilkadaciamis2018.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import atps_company.pilkadaciamis2018.R;
import atps_company.pilkadaciamis2018.model.PetugasBawaslu;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by emerio on 4/9/17.
 */

public class PetugasBawasluAdapter extends RecyclerView.Adapter<PetugasBawasluAdapter.PetugasBawasluHolder> {
    private List<PetugasBawaslu> petugasBawasluList;
    private PetugasBawasluAdapterCallback mCallback;

    @Inject
    public PetugasBawasluAdapter() {
        petugasBawasluList = new ArrayList<>();
    }
    public void setPetugasBawaslu(List<PetugasBawaslu> listPetugasBawaslu) {
        this.petugasBawasluList.addAll(listPetugasBawaslu);
    }
    @Override
    public PetugasBawasluHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_petugas_bawaslu,
                parent, false);
        return new PetugasBawasluHolder(view);
    }

    @Override
    public void onBindViewHolder(PetugasBawasluHolder holder, int position) {
        PetugasBawaslu petugasBawaslu = petugasBawasluList.get(position);
        holder.setPetugasBawaslu(petugasBawaslu);
        holder.namaPetugas.setText(petugasBawaslu.getNama());
        holder.jabatan.setText(petugasBawaslu.getJabatan());
    }
   private void simpleDateFormat(String date){

   }
    public void setCallback(PetugasBawasluAdapterCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public int getItemCount() {
        return petugasBawasluList.size();
    }

    class PetugasBawasluHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.namaPetugas)
        TextView namaPetugas;
        @BindView(R.id.jabatan)
        TextView jabatan;
        PetugasBawaslu petugasBawaslu;
        public PetugasBawasluHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        public void setPetugasBawaslu(PetugasBawaslu petugasBawaslu) {
            this.petugasBawaslu = petugasBawaslu;
        }
        @OnClick(R.id.row_layout)
        void onItemClicked(View view) {
            if (mCallback != null) mCallback.onPetugasBawasluClicked(petugasBawaslu);
        }
    }

    public static interface PetugasBawasluAdapterCallback {
        public void onPetugasBawasluClicked(PetugasBawaslu petugasBawaslu);
    }
}
