package paul.develops.ta.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import paul.develops.ta.Models.InformasiModel;
import paul.develops.ta.R;
import paul.develops.ta.REST.RestClient;

/**
 * Created by paulms on 12/6/2016.
 */

public class InformasiAdapter extends ArrayAdapter<InformasiModel> {
    private Context mContext;
    ArrayList<InformasiModel> information;

    RestClient restClient;

    static class ViewHolder {
        public TextView namaGame;
        public ImageView gambarGame;
    }

    public InformasiAdapter(Context _context, ArrayList<InformasiModel> _mylist) {
        super(_context, R.layout.hewan, _mylist);
        mContext = _context;
        this.information = _mylist;
    }

    public void setProducts(ArrayList<InformasiModel> products) {
        this.information.clear();
        for (int i = 0; i < products.size(); i++) {
            this.information.add(products.get(i));
        }
        notifyDataSetChanged();
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        InformasiModel informasi = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            //membuat baru item
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.hewan, parent, false);
            viewHolder.namaGame= (TextView) convertView.findViewById(R.id.txtInfoHewan);
            viewHolder.gambarGame = (ImageView) convertView.findViewById(R.id.imgHewanInfo);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.namaGame.setText(informasi.getInformasi());
        Picasso.with(viewHolder.gambarGame.getContext())
                .load(restClient.url()+"/images/gameicon/"+informasi.getUrl_gambar()).resize(120, 120).centerCrop()
                .placeholder(R.drawable.sayuran2)
                .error(R.drawable.keluarga2)
                .into(viewHolder.gambarGame);

        return convertView;
    }
}
