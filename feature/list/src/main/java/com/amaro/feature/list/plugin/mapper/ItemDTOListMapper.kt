package com.amaro.feature.list.plugin.mapper

import com.amaro.feature.list.domain.model.Item
import com.amaro.feature.list.domain.model.Owner
import com.amaro.libraries.core.domain.mapper.ListMapper
import com.amaro.libraries.networking.domain.model.ItemDTO
import com.amaro.libraries.networking.domain.model.OwnerDTO

class ItemDTOListMapper : ListMapper<ItemDTO, Item> {
    override fun map(input: List<ItemDTO>): List<Item> {
        return input.map {
            Item(
                it.id,
                it.name,
                toOwner(it.owner),
                it.fullName,
                it.starCount,
                it.forksCount
            )
        }
    }

    private fun toOwner(ownerDTO: OwnerDTO): Owner {
        return Owner(
            ownerDTO.id,
            ownerDTO.login,
            ownerDTO.avatarUrl
        )
    }
}