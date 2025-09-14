package DoubleBuff.patchs;

import DoubleBuff.utils.Invoker;
import com.evacipated.cardcrawl.modthespire.lib.ByRef;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.exordium.TheGuardian;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.InvinciblePower;

@SpirePatch(
        clz = TheGuardian.class,
        method = SpirePatch.CONSTRUCTOR

)
public class TheGuardianPatch {

    @SpirePostfixPatch
    public static void Postfix(TheGuardian __instance) {
        Invoker.setField(__instance, "dmgThreshold", 80);
    Invoker.setField(__instance, "dmgThresholdIncrease", 20);


    }}