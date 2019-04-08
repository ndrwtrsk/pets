package ua.pl.pets.api.query

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("PetSitter")
class PetSitterDto(@ApiModelProperty(required = true) val id: Long,
                   @ApiModelProperty(required = true) val name: String)