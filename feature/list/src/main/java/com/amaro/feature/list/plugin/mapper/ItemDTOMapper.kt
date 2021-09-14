package com.amaro.feature.list.plugin.mapper

import com.amaro.feature.list.domain.model.Item
import com.amaro.feature.list.domain.model.Owner
import com.amaro.libraries.core.domain.mapper.Mapper
import com.amaro.libraries.networking.domain.model.ItemDTO
import com.amaro.libraries.networking.domain.model.OwnerDTO

class ItemDTOMapper: Mapper<ItemDTO, Item> {
    override fun map(input: ItemDTO): Item {
        return Item(
            input.id,
            input.name,
            toOwner(input.owner),
            input.fullName,
            input.starCount,
            input.forksCount
        )
    }

    private fun toOwner(ownerDTO: OwnerDTO): Owner {
        return Owner(
            ownerDTO.id,
            ownerDTO.login,
            ownerDTO.avatarUrl
        )
    }
}