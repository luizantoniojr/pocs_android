package com.pocs.viagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pocs.viagens.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import br.com.alura.aluraviagens.model.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = this.getItem(position);

        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());

        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(pacote.getImagem(), "drawable", context.getPackageName());
        Drawable drawable = resources.getDrawable(idDrawable);
        imagem.setImageDrawable(drawable);

        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        int quantidadeDias = pacote.getDias();
        dias.setText(context.getResources().getQuantityString(R.plurals.plural_dia, quantidadeDias, quantidadeDias));

        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        NumberFormat formatadorRealBrasil = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        String precoFormatado = formatadorRealBrasil.format(pacote.getPreco());
        preco.setText(precoFormatado);

        return viewCriada;
    }
}
