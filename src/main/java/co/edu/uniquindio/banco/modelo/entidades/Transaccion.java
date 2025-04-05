package co.edu.uniquindio.banco.modelo.entidades;

import co.edu.uniquindio.banco.modelo.enums.Categoria;
import co.edu.uniquindio.banco.modelo.enums.TipoTransaccion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * Clase que representa una transacción bancaria
 * @version 1.0
 * @author caflorezvi
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaccion {
    private String id;
    private float monto;
    private LocalDateTime fecha;
    private Categoria categoria;
    private BilleteraVirtual billeteraOrigen, billeteraDestino;
    private float comision;
    private TipoTransaccion tipoTransaccion;

    public Transaccion(String id, float monto, LocalDateTime fecha, Categoria categoria, BilleteraVirtual billeteraOrigen, BilleteraVirtual billeteraDestino, float comision) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.categoria = categoria;
        this.billeteraOrigen = billeteraOrigen;
        this.billeteraDestino = billeteraDestino;
        this.comision = comision;
    }

    public String obtenerMontoCadena(){
        return String.valueOf(monto);
    }

    public Usuario obtenerUsuario() {
        Usuario usuario = null;
        switch (tipoTransaccion){
            case RETIRO:
                usuario = billeteraDestino.getUsuario();
                break;
            case DEPOSITO:
                usuario = billeteraOrigen.getUsuario();
                break;
        }
        return usuario;
    }

    public TipoTransaccion obtenerTipo(BilleteraVirtual billeteraOr){
        if(billeteraOr.equals(billeteraOrigen)){
            return TipoTransaccion.RETIRO;
        }
        return TipoTransaccion.DEPOSITO;
    }


}
