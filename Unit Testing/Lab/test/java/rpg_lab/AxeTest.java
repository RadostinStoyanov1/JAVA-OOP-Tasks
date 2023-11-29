package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {

    private static final int ATTACK = 12;
    public static final int DURABILITY = 20;
    public static final int HEALTH = 100;
    public static final int EXPERIENCE = 200;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.axe = new Axe(ATTACK, DURABILITY);
        this.dummy = new Dummy(HEALTH, EXPERIENCE);
    }

    @Test
    public void test_CreateAxe_ShouldSet_CorrectValues_ForAttackAndDurability() {

        Assert.assertEquals(ATTACK, axe.getAttackPoints());
        Assert.assertEquals(DURABILITY, axe.getDurabilityPoints());
    }

    @Test
    public void test_Attack_Removes_DurabilityPoints() {
        //Act
        axe.attack(dummy);
        //Assert
        Assert.assertEquals(DURABILITY - 1, axe.getDurabilityPoints());

    }

    @Test(expected = IllegalStateException.class)
    public void test_Attack_WithBrokenWeapon_ShouldFail() {

        Axe axe = new Axe(ATTACK, 0);
        axe.attack(dummy);

        String message = Assert.assertThrows(IllegalStateException.class, () -> axe.attack(dummy)).getMessage();
        Assert.assertEquals("Axe is broken.", message);
    }
}
