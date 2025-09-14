package DoubleBuff.patchs;


import DoubleBuff.utils.Invoker;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.map.RoomTypeAssigner;
import com.megacrit.cardcrawl.monsters.exordium.TheGuardian;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.InvinciblePower;
import com.megacrit.cardcrawl.powers.ModeShiftPower;
import com.megacrit.cardcrawl.rooms.MonsterRoomElite;

import java.util.ArrayList;

import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.map;


@SpirePatch(
        clz = ApplyPowerAction.class,
        method = SpirePatch.CONSTRUCTOR
        ,paramtypez = {AbstractCreature.class, AbstractCreature.class, AbstractPower.class, int.class, boolean.class, AbstractGameAction.AttackEffect.class}
)
public class ApplyPowerActionPatch {

    @SpirePostfixPatch
    public static void Postfix(ApplyPowerAction  __instance, AbstractCreature target, AbstractCreature source, AbstractPower powerToApply, int stackAmount, boolean isFast, AbstractGameAction.AttackEffect effect) {
        if (powerToApply instanceof ModeShiftPower){
            return;
        }
        powerToApply.amount*=2;
        if (powerToApply instanceof InvinciblePower){
            Invoker.setField(powerToApply, "maxAmt", powerToApply.amount);
        }

        Invoker.setField(__instance, "amount", powerToApply.amount);
    
    }

}
