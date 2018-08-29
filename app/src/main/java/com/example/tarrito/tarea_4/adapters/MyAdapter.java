package com.example.tarrito.tarea_4.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import  com.example.tarrito.tarea_4.R;
import com.example.tarrito.tarea_4.models.Alumno;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    private List<Alumno> list;
    private int layout;
    private Context context;

    public MyAdapter(List<Alumno> list, int layout, Context context) {
        this.list = list;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Alumno getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, null);
            vh = new ViewHolder();
            vh.id = (TextView) convertView.findViewById(R.id.textViewId);
            vh.rut = (TextView) convertView.findViewById(R.id.textViewRut);
            vh.nombre = (TextView) convertView.findViewById(R.id.textViewNombre);
            vh.apellidos = (TextView) convertView.findViewById(R.id.textViewApellidos);
            vh.edad = (TextView) convertView.findViewById(R.id.textViewEdad);
            vh.carrera = (TextView) convertView.findViewById(R.id.textViewCarrera);
            vh.ano = (TextView) convertView.findViewById(R.id.textViewAño);
            vh.semestre = (TextView) convertView.findViewById(R.id.textViewSemestre);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        Alumno p = list.get(position);
        vh.id.setText(p.getId() + "");
        vh.rut.setText(p.getRut());
        vh.nombre.setText(p.getNombre());
        vh.apellidos.setText(p.getApellidos());
        vh.edad.setText(p.getEdad() +"");
        vh.carrera.setText(p.getCarrera());
        vh.ano.setText(p.getAno()+ "");
        vh.semestre.setText(p.getSemestre());

        return convertView;
    }
    public class ViewHolder {
        TextView id;
        TextView rut;
        TextView nombre;
        TextView apellidos;
        TextView edad;
        TextView carrera;
        TextView ano;
        TextView semestre;
    }
}