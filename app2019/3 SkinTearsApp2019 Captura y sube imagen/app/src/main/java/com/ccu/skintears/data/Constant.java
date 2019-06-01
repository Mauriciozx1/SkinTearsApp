package com.ccu.skintears.data;

import com.ccu.skintears.fragment.ContenidoMod1Fragment;
import com.ccu.skintears.fragment.ContenidoMod2Fragment;
import com.ccu.skintears.fragment.ContenidoMod3Fragment;
import com.ccu.skintears.fragment.EvaluacionMod1Fragment;
import com.ccu.skintears.fragment.EvaluacionMod2Fragment;
import com.ccu.skintears.fragment.EvaluacionMod3Fragment;
import com.ccu.skintears.fragment.InicioFragment;
import com.ccu.skintears.fragment.ReconocimientoHeridaFragment;
import com.ccu.skintears.fragment.TratamientoTipo1Fragment;
import com.ccu.skintears.fragment.TratamientoTipo2Fragment;
import com.ccu.skintears.fragment.TratamientoTipo3Fragment;
import com.ccu.skintears.navigationdrawer.NavMenuModel;
import com.ccu.skintears.R;

import java.util.ArrayList;

/**
 * Created by miki on 7/7/17.
 */

public class Constant {

    public static ArrayList<NavMenuModel> getMenuNavigasi(){
        ArrayList<NavMenuModel> menu = new ArrayList<>();

        menu.add(new NavMenuModel("Inicio", R.drawable.ic_beranda, InicioFragment.newInstance("¡Bienvenido!")));

        menu.add(new NavMenuModel("Contenidos", R.drawable.ic_book,
                new ArrayList<NavMenuModel.SubMenuModel>() {{
                    add(new NavMenuModel.SubMenuModel("Módulo Nº 1", ContenidoMod1Fragment.newInstance("Aprendamos")));
                    add(new NavMenuModel.SubMenuModel("Módulo Nº 2", ContenidoMod2Fragment.newInstance("Aprendamos")));
                    add(new NavMenuModel.SubMenuModel("Módulo Nº 3", ContenidoMod3Fragment.newInstance("Aprendamos")));

                }}));

        menu.add(new NavMenuModel("Tratamientos", R.drawable.ic_health,
                new ArrayList<NavMenuModel.SubMenuModel>() {{
                    add(new NavMenuModel.SubMenuModel("Heridas Tipo 1", TratamientoTipo1Fragment.newInstance("Aprendamos")));
                    add(new NavMenuModel.SubMenuModel("Heridas Tipo 2", TratamientoTipo2Fragment.newInstance("Aprendamos")));
                    add(new NavMenuModel.SubMenuModel("Heridas Tipo 3", TratamientoTipo3Fragment.newInstance("Aprendamos")));

                }}));

        menu.add(new NavMenuModel("Evaluaciones", R.drawable.ic_test,
                new ArrayList<NavMenuModel.SubMenuModel>() {{
                    add(new NavMenuModel.SubMenuModel("Evaluación Módulo", EvaluacionMod1Fragment.newInstance("Suerte")));

                }}));

        menu.add(new NavMenuModel("Reconocimiento", R.drawable.ic_camera, ReconocimientoHeridaFragment.newInstance("Skin Tears")));


        return menu;
    }
}
