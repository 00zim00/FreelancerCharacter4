package ffzim.cards.BlackMage;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.PurgeField;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import ffzim.cards.BaseCard;
import ffzim.character.Freelancer;
import ffzim.powers.UmbralIcePower;
import ffzim.util.CardInfo;
import ffzim.util.CustomTags;

import static ffzim.BasicMod.makeID;

public class Blizzaga extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Blizzaga",
            2,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            Freelancer.Enums.FFcardColor);

    public static final String ID = makeID(cardInfo.baseId);
    private static final int DAMAGE = 15;
    private static final int UPG_DAMAGE = 5;
    private static final int ASTRAL_ICE = 6;
    private static final int UPG_ASTRAL_ICE  = 6;
    private boolean isInPreview;
    public Blizzaga() {
        this(true);
    }

    public Blizzaga(boolean makePreview) {
        super(cardInfo, true);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(ASTRAL_ICE,UPG_ASTRAL_ICE);
        PurgeField.purge.set(this, true);
        tags.add(CustomTags.FFSPELL);
        this.isInPreview = makePreview;
        this.rarity = CardRarity.RARE;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            upgradeDamage(UPG_DAMAGE);
            upgradeMagicNumber(UPG_ASTRAL_ICE);
            this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(p,p, new UmbralIcePower(p, this.magicNumber), this.magicNumber));
    }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new Blizzaga();
    }
}
