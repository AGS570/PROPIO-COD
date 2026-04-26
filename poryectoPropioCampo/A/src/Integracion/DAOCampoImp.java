package Integracion;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import Negocio.TCampo;
import Negocio.TCampoExterior;
import Negocio.TCampoInterior;

import java.util.ArrayList;

public class DAOCampoImp implements DAOCampo {
    private static final Map<String, TCampo> CAMPOS = new HashMap<>();

    @Override
    public int create(TCampo t) {
        if (t == null || t.getID() == null || t.getID().isBlank() || CAMPOS.containsKey(t.getID())) {
            return -1;
        }

        CAMPOS.put(t.getID(), clonarCampo(t));
        return 1;
    }

    @Override
    public TCampo read(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }

        TCampo campo = CAMPOS.get(id);
        return campo == null ? null : clonarCampo(campo);
    }

    @Override
    public Collection<TCampo> readAll() {
        Collection<TCampo> resultado = new ArrayList<>();
        for (TCampo campo : CAMPOS.values()) {
            resultado.add(clonarCampo(campo));
        }
        return resultado;
    }

    @Override
    public int update(TCampo tCampo) {
        if (tCampo == null || tCampo.getID() == null || tCampo.getID().isBlank() || !CAMPOS.containsKey(tCampo.getID())) {
            return -1;
        }

        CAMPOS.put(tCampo.getID(), clonarCampo(tCampo));
        return 1;
    }

    @Override
    public int delete(String id) {
        if (id == null || id.isBlank() || !CAMPOS.containsKey(id)) {
            return -1;
        }

        CAMPOS.remove(id);
        return 1;
    }

    @Override
    public Collection<TCampo> readCamposMantenimiento() {
        Collection<TCampo> resultado = new ArrayList<>();
        for (TCampo campo : CAMPOS.values()) {
            if (campo.getOcupado()) {
                resultado.add(clonarCampo(campo));
            }
        }
        return resultado;
    }

    private TCampo clonarCampo(TCampo original) {
        if (original instanceof TCampoInterior) {
            TCampoInterior interior = (TCampoInterior) original;
            return new TCampoInterior(
                interior.getID(),
                interior.getOcupado(),
                interior.getTipoSuperficie(),
                interior.getAcondicionado()
            );
        }

        if (original instanceof TCampoExterior) {
            TCampoExterior exterior = (TCampoExterior) original;
            return new TCampoExterior(
                exterior.getID(),
                exterior.getOcupado(),
                exterior.getTipoSuperficie(),
                exterior.getClima()
            );
        }

        return new TCampo(original.getID(), original.getOcupado(), original.getTipoSuperficie());
    }
}
