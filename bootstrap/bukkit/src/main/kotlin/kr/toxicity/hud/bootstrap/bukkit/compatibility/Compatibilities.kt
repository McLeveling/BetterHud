package kr.toxicity.hud.bootstrap.bukkit.compatibility

import com.mcleveling.rpg.player.RPGProfile
import com.mcleveling.rpg.skills.types.RegisteredSkill
import io.lumine.mythic.lib.api.player.MMOPlayerData
import io.lumine.mythic.lib.player.cooldown.CooldownObject
import io.lumine.mythic.lib.skill.handler.SkillHandler

typealias MMOCorePlayer = RPGProfile
typealias MMOItemsPlayer = net.Indyuce.mmoitems.api.player.PlayerData

typealias MMOCoreSkill = RegisteredSkill
typealias MMOItemsSkill = net.Indyuce.mmoitems.skill.RegisteredSkill

fun MMOCorePlayer.cooldown(skill: CooldownObject) = mmoPlayerData.cooldown(skill)
fun MMOCorePlayer.cooldown(handler: SkillHandler<*>) = mmoPlayerData.cooldown(handler)
fun MMOCorePlayer.cooldown(skill: MMOCoreSkill) = mmoPlayerData.cooldown(skill.handler)

fun MMOItemsPlayer.cooldown(skill: CooldownObject) = mmoPlayerData.cooldown(skill)
fun MMOItemsPlayer.cooldown(handler: SkillHandler<*>) = mmoPlayerData.cooldown(handler)
fun MMOItemsPlayer.cooldown(skill: MMOItemsSkill) = mmoPlayerData.cooldown(skill.handler)

fun MMOPlayerData.cooldown(skill: CooldownObject) = cooldownMap.getCooldown(skill)
fun MMOPlayerData.cooldown(handler: SkillHandler<*>) = cooldownMap.getCooldown("skill_" + handler.id)