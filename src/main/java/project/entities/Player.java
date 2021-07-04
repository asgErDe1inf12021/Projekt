package project.entities;

import de.gurkenlabs.litiengine.Align;
import de.gurkenlabs.litiengine.Valign;
import de.gurkenlabs.litiengine.attributes.Attribute;
import de.gurkenlabs.litiengine.entities.*;
import de.gurkenlabs.litiengine.entities.behavior.IBehaviorController;
import de.gurkenlabs.litiengine.environment.Environment;
import de.gurkenlabs.litiengine.environment.tilemap.ICustomPropertyProvider;
import de.gurkenlabs.litiengine.environment.tilemap.xml.CustomPropertyProvider;
import de.gurkenlabs.litiengine.graphics.RenderType;
import de.gurkenlabs.litiengine.graphics.animation.IEntityAnimationController;
import de.gurkenlabs.litiengine.physics.Collision;
import de.gurkenlabs.litiengine.physics.CollisionEvent;
import de.gurkenlabs.litiengine.physics.IMovementController;
import project.input.KeyboardEntityController;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Player implements IMobileEntity {
    @Override
    public void onMoved(EntityMovedListener listener) {

    }

    @Override
    public void removeMovedListener(EntityMovedListener listener) {

    }

    @Override
    public int getAcceleration() {
        return 0;
    }

    @Override
    public int getDeceleration() {
        return 0;
    }

    @Override
    public Attribute<Float> getVelocity() {
        return null;
    }

    @Override
    public float getTickVelocity() {
        return 0;
    }

    @Override
    public IMovementController movement() {
        return new KeyboardEntityController<>(this);
    }

    @Override
    public void setAcceleration(int acceleration) {

    }

    @Override
    public void setDeceleration(int deceleration) {

    }

    @Override
    public void setTurnOnMove(boolean turn) {

    }

    @Override
    public void setVelocity(float velocity) {

    }

    @Override
    public boolean turnOnMove() {
        return false;
    }

    @Override
    public void onCollision(CollisionListener listener) {

    }

    @Override
    public void removeCollisionListener(CollisionListener listener) {

    }

    @Override
    public void fireCollisionEvent(CollisionEvent event) {

    }

    @Override
    public boolean canCollideWith(ICollisionEntity otherEntity) {
        return false;
    }

    @Override
    public Rectangle2D getCollisionBox() {
        return new Rectangle(0, 0, 10, 10);
    }

    @Override
    public Rectangle2D getCollisionBox(Point2D location) {
        return new Rectangle((Point) location, new Dimension(10, 10));
    }

    @Override
    public Point2D getCollisionBoxCenter() {
        return new Point(0, 0);
    }

    @Override
    public Valign getCollisionBoxValign() {
        return Valign.TOP;
    }

    @Override
    public Align getCollisionBoxAlign() {
        return Align.LEFT;
    }

    @Override
    public Collision getCollisionType() {
        return Collision.NONE;
    }

    @Override
    public double getCollisionBoxHeight() {
        return 10;
    }

    @Override
    public double getCollisionBoxWidth() {
        return 10;
    }

    @Override
    public boolean hasCollision() {
        return false;
    }

    @Override
    public void setCollision(boolean collision) {

    }

    @Override
    public void setCollisionBoxHeight(double collisionBoxHeight) {

    }

    @Override
    public void setCollisionBoxWidth(double collisionBoxWidth) {

    }

    @Override
    public void setCollisionBoxAlign(Align align) {

    }

    @Override
    public void setCollisionBoxValign(Valign valign) {

    }

    @Override
    public void setCollisionType(Collision collisionType) {

    }

    @Override
    public void onMessage(EntityMessageListener listener) {

    }

    @Override
    public void onMessage(String message, EntityMessageListener listener) {

    }

    @Override
    public void addTransformListener(EntityTransformListener listener) {

    }

    @Override
    public void addListener(EntityListener listener) {

    }

    @Override
    public void removeListener(EntityMessageListener listener) {

    }

    @Override
    public void removeListener(EntityTransformListener listener) {

    }

    @Override
    public void removeListener(EntityListener listener) {

    }

    @Override
    public void onRendered(EntityRenderedListener listener) {

    }

    @Override
    public void removeListener(EntityRenderedListener listener) {

    }

    @Override
    public void addEntityRenderListener(EntityRenderListener listener) {

    }

    @Override
    public void removeListener(EntityRenderListener listener) {

    }

    @Override
    public double getAngle() {
        return 0;
    }

    @Override
    public void setAngle(double angle) {

    }

    @Override
    public IEntityAnimationController<?> animations() {
        return null;
    }

    @Override
    public boolean isVisible() {
        return true;
    }

    @Override
    public void setVisible(boolean visible) {

    }

    @Override
    public IBehaviorController behavior() {
        return null;
    }

    @Override
    public void addController(IEntityController controller) {

    }

    @Override
    public <T extends IEntityController> void setController(Class<T> clss, T controller) {

    }

    @Override
    public <T extends IEntityController> T getController(Class<T> clss) {
        return null;
    }

    @Override
    public EntityActionMap actions() {
        return null;
    }

    @Override
    public void perform(String actionName) {

    }

    @Override
    public EntityAction register(String name, Runnable action) {
        return null;
    }

    @Override
    public void detachControllers() {

    }

    @Override
    public void attachControllers() {

    }

    @Override
    public Rectangle2D getBoundingBox() {
        return null;
    }

    @Override
    public Point2D getCenter() {
        return null;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public Point2D getLocation() {
        return new Point();
    }

    @Override
    public int getMapId() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public RenderType getRenderType() {
        return RenderType.NORMAL;
    }

    @Override
    public boolean renderWithLayer() {
        return false;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getX() {
        return 0;
    }

    @Override
    public double getY() {
        return 0;
    }

    @Override
    public String sendMessage(Object sender, String message) {
        return "";
    }

    @Override
    public void setHeight(double height) {

    }

    @Override
    public void setLocation(double x, double y) {

    }

    @Override
    public boolean hasTag(String tag) {
        return false;
    }

    @Override
    public List<String> getTags() {
        return new ArrayList<>();
    }

    @Override
    public void addTag(String tag) {

    }

    @Override
    public void removeTag(String tag) {

    }

    @Override
    public void setLocation(Point2D location) {

    }

    @Override
    public void setMapId(int mapId) {

    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void setRenderType(RenderType renderType) {

    }

    @Override
    public void setRenderWithLayer(boolean renderWithLayer) {

    }

    @Override
    public void setSize(double width, double height) {

    }

    @Override
    public void setWidth(double width) {

    }

    @Override
    public void setX(double x) {

    }

    @Override
    public void setY(double y) {

    }

    @Override
    public ICustomPropertyProvider getProperties() {
        return new CustomPropertyProvider();
    }

    @Override
    public Environment getEnvironment() {
        return null;
    }

    @Override
    public void loaded(Environment environment) {

    }

    @Override
    public void removed(Environment environment) {

    }

    @Override
    public boolean isLoaded() {
        return true;
    }
}
