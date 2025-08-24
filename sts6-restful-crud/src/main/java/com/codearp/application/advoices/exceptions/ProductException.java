package com.codearp.application.advoices.exceptions;

/**
 * Spring realice un rollback de la transacción ante una excepción, debes lanzar una RuntimeException o un Error (por defecto) o,
 * si quieres que se haga rollback con una excepción "checked" (que no sean RuntimeException),
 * debes especificarla usando el atributo rollbackFor de la anotación @Transactional.
 *
 * Por ejemplo, @Transactional(rollbackFor = Exception.class) hará que la transacción se revierta ante cualquier Exception.
 *
 */
public class ProductException extends RuntimeException{

    public ProductException(String msg){
        super(msg);
    }

    public ProductException(String message, Throwable cause){
        super(message,cause);
    }

    public ProductException(Throwable cause){
        super(cause);
    }
}
