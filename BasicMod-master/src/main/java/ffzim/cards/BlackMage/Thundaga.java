package ffzim.cards.BlackMage;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.PurgeField;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import ffzim.actions.FFThunderAction;
import ffzim.cards.BaseCard;
import ffzim.character.Freelancer;
import ffzim.util.CardInfo;
import ffzim.util.CustomTags;

import static ffzim.BasicMod.makeID;

public class Thundaga extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Thundaga",
            2,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            Freelancer.Enums.FFcardColor);

    public static final String ID = makeID(cardInfo.baseId);
    private static final int DAMAGE = 4;
    private static final int UPG_DAMAGE = 4;
    private static final int XTIMES = 4;

    private boolean isInPreview;
    public Thundaga() {
        this(true);
    }
    public Thundaga(boolean makePreview) {
        super(cardInfo, true);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(XTIMES);
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
            this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < XTIMES; i++) {
            addToBot(new FFThunderAction(this));
        }
    }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new Thundaga();
    }
}
