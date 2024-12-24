package com.horax.timeManagement.domain;

/**
 * Dépôt de base avec une fonctionnalité ajoutée de modification.
 * 
 * @author cboileau
 *
 * @param <I>
 * @param <E>
 */
public interface DeleteRepository<I, E> extends BasicRepository<I, E> {

    void delete(I id);
}
