//package ffzim.cards.BlackMage;
//
//import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.PurgeField;
//import com.megacrit.cardcrawl.actions.AbstractGameAction;
//import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
//import com.megacrit.cardcrawl.actions.common.DamageAction;
//import com.megacrit.cardcrawl.cards.AbstractCard;
//import com.megacrit.cardcrawl.cards.DamageInfo;
//import com.megacrit.cardcrawl.characters.AbstractPlayer;
//import com.megacrit.cardcrawl.monsters.AbstractMonster;
//import ffzim.actions.keywords.LevelUpAction;
//import ffzim.cards.BaseCard;
//import ffzim.cards.WhiteMage.Gems.FireMateria;
//import ffzim.powers.AstralFirePower;
//import ffzim.util.CardInfo;
//import ffzim.util.CustomTags;
//
//import static ffzim.BasicMod.makeID;
//
//public class FireBU extends BaseCard {
//    private final static CardInfo cardInfo = new CardInfo(
//            "FireBU",
//            1,
//            CardType.ATTACK,
//            CardTarget.ENEMY,
//            CardRarity.SPECIAL,
//            CardColor.COLORLESS); 
//            //MyCharacter.Enums.FFcardColor);
//// StaffFireEffec
//
//    public static final String ID = makeID(cardInfo.baseId);
//    private static final int DAMAGE = 9;
//    private static final int UPG_DAMAGE = 3;
//    private static final int ASTRAL_FIRE = 1;
//    private static final int UPG_ASTRAL_FIRE  = 1;
//    private boolean isInPreview;
//
//    public FireBU() {this(true);}
//
//    public FireBU(boolean makePreview) {
//        super(cardInfo, true);
//        setDamage(DAMAGE, UPG_DAMAGE);
//        setMagic(ASTRAL_FIRE,UPG_ASTRAL_FIRE);
//        setLevelUp(true);
//        PurgeField.purge.set(this, true);
//        tags.add(CustomTags.FFSPELL);
//        tags.add(CustomTags.FFLEVELUP);
//        if (makePreview) {
//            cardsToPreview = new Fira(false);
//        }
//        this.isInPreview = makePreview;
//    }
//
//    @Override
//    public void upgrade() {
//        if (!this.upgraded) {
//            this.upgradeName();
//            upgradeDamage(UPG_DAMAGE);
//            upgradeMagicNumber(UPG_ASTRAL_FIRE);
//            if (isInPreview ) {
//                this.cardsToPreview.upgrade();
//            }
//            this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
//            this.initializeDescription();
//        }
//    }
//
//    @Override
//    public void use(AbstractPlayer p, AbstractMonster m) {
//        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.FIRE));
//        addToBot(new LevelUpAction(p,p,isLevelUp(),new FireMateria(),new Fira(),true,false,false, this.upgraded, this.purgeOnUse));
//        addToBot(new ApplyPowerAction(p,p, new AstralFirePower(p, this.magicNumber), this.magicNumber));
//    }
//
//
//    @Override
//    public AbstractCard makeCopy() { //Optional
//        return new FireBU();
//    }
//}
