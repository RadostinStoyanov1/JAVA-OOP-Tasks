package rpg_lab;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.Assert.*;

public class HeroTest {

    private static final int EXPERIENCE = 200;

    @Test
    public void test_Hero_Gets_Experience_When_Target_Dies() {

        Weapon weaponMock = Mockito.mock(Weapon.class);

        Target targetMock = Mockito.mock(Target.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(EXPERIENCE);

        Hero hero = new Hero("Pointer", weaponMock);
        hero.attack(targetMock);
        assertEquals(EXPERIENCE, hero.getExperience());
    }

}