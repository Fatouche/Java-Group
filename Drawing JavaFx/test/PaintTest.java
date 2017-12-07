import drawing.*;
import drawing.shapes.Circle;
import drawing.shapes.Group;
import drawing.shapes.Rectangle;
import drawing.shapes.Shape;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.Test;
import static org.testfx.api.FxAssert.*;

import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.*;

public class PaintTest extends ApplicationTest {

    Paint app;

    @Override
    public void start(Stage stage) {
        try {
            app = new Paint();
            app.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void should_draw_circle_programmatically() {
        interact(() -> {
                    app.getDrawing().addShape(new Circle(new Point2D(20, 20), 30));
                });
        Iterator it = app.getDrawing().iterator();
        assertTrue(it.next() instanceof Circle);
        assertFalse(it.hasNext());
    }

    @Test
    public void should_draw_circle() {
        // given:
        clickOn("Cercle");
        moveBy(60,60);

        // when:
        drag().dropBy(30,30);
        //press(MouseButton.PRIMARY); moveBy(30,30); release(MouseButton.PRIMARY);

        // then:
        Iterator it = app.getDrawing().iterator();
        assertTrue(it.next() instanceof Circle);
        assertFalse(it.hasNext());
    }

    @Test
    public void should_draw_rectangle() {
        // given:
        clickOn("Rectangle");
        moveBy(0,60);

        // when:
        drag().dropBy(70,40);

        // then:
        Iterator it = app.getDrawing().iterator();
        assertTrue(it.next() instanceof Rectangle);
        assertFalse(it.hasNext());
    }

    @Test
    public void should_clear() {
        // given:
        clickOn("Rectangle");
        moveBy(30,60).drag().dropBy(70,40);
        clickOn("Cercle");
        moveBy(-30,160).drag().dropBy(70,40);

        // when:
        clickOn("Clear");

        // then:
        assertFalse(app.getDrawing().iterator().hasNext());
    }

    @Test
    public void status_bar_test() {
        interact(() -> {
                    app.getDrawing().addShape(new Circle(new Point2D(20, 20), 30));
                });
        verifyThat(".label", NodeMatchers.hasText("1 shape(s)"));

        interact(() -> {
                    app.getDrawing().addShape(new Circle(new Point2D(10, 50), 30));
                });
        verifyThat(".label", NodeMatchers.hasText("2 shape(s)"));

        clickOn("Clear");
        verifyThat(".label", NodeMatchers.hasText("0 shape(s)"));
    }

    @Test
    public void should_group() {
        //given
        Circle cercle1 = new Circle(new Point2D(0, 0), 50);
        Circle cercle2 = new Circle(new Point2D(100, 100), 50);
        interact(() -> {
            app.getDrawing().addShape(cercle1);
            app.getDrawing().addShape(cercle2);
        });
        moveTo(bounds(app.getDrawing()).query().getMinX()+5, bounds(app.getDrawing()).query().getMinY()+5);
        clickOn().press(KeyCode.SHIFT).moveBy(100,100).clickOn().release(KeyCode.SHIFT);

        //when
        clickOn("Group");

        //then
        Iterator<Shape> it = app.getDrawing().iterator();
        assertTrue(it.hasNext());
        Shape s = it.next();
        assertTrue(s instanceof Group);
        Collection<Shape> grpShapes = ((Group)s).getShapes();
        assertEquals(2, grpShapes.size());
        assertTrue(grpShapes.contains(cercle1));
        assertTrue(grpShapes.contains(cercle2));
        assertFalse(it.hasNext());
    }

    @Test
    public void should_degroup() {
        fail("Not implemented yet");
    }

    @Test
    public void should_clone() {
        fail("Not implemented yet");
    }

}