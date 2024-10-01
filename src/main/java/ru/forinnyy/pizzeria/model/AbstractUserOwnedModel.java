package ru.forinnyy.pizzeria.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractUserOwnedModel extends AbstractModel {

    private String userId;

}
