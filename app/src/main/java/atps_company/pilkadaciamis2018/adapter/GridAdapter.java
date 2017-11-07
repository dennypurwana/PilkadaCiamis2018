package atps_company.pilkadaciamis2018.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import atps_company.pilkadaciamis2018.R;
import atps_company.pilkadaciamis2018.model.CalonPasangan;
import atps_company.pilkadaciamis2018.model.PetugasBawaslu;


public class GridAdapter extends BaseAdapter {
    private Context mContext;
    private List<PetugasBawaslu> arrayList;
    public GridAdapter(Context c, List<PetugasBawaslu> mArrayList) {
        mContext = c;
        this.arrayList = mArrayList;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View grid;
        PetugasBawaslu petugasBawaslu = arrayList.get(i);
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_items, null);
            TextView textView = (TextView) grid.findViewById(R.id.name);
            TextView textView2 = (TextView) grid.findViewById(R.id.jabatan);
            ImageView imageView = (ImageView) grid.findViewById(R.id.image);
            textView.setText(petugasBawaslu.getNama());
            textView2.setText(petugasBawaslu.getJabatan());
        } else {
            grid = (View) convertView;
        }

        return grid;
    }

}
