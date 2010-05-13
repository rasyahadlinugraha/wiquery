/*
 * Copyright (c) 2009 WiQuery team
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.odlabs.wiquery.ui.draggable;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.odlabs.wiquery.core.behavior.WiQueryAbstractBehavior;
import org.odlabs.wiquery.core.commons.WiQueryResourceManager;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.core.options.ArrayItemOptions;
import org.odlabs.wiquery.core.options.ICollectionItemOptions;
import org.odlabs.wiquery.core.options.IComplexOption;
import org.odlabs.wiquery.core.options.IntegerItemOptions;
import org.odlabs.wiquery.core.options.Options;
import org.odlabs.wiquery.ui.core.CoreUIJavaScriptResourceReference;
import org.odlabs.wiquery.ui.core.JsScopeUiEvent;

/**
 * $Id$
 * <p>
 * Sets the attached component draggable.
 * </p>
 * 
 * @author Lionel Armanet
 * @since 1.0
 */
public class DraggableBehavior extends WiQueryAbstractBehavior {
	/**
	 * Enumeration for the axis option
	 * @author Julien Roche
	 *
	 */
	public enum AxisEnum {
		X,
		Y;
	}
	
	/**
	 * Enumeration for the cursorAt option
	 * @author Julien Roche
	 *
	 */
	public enum CursorAtEnum {
		TOP,
		TOP_LEFT,
		TOP_RIGHT,
		LEFT,
		RIGHT,
		BOTTOM,
		BOTTOM_LEFT,
		BOTTOM_RIGHT;
	}
	
	/**
	 * Enumeration for the snapMode option
	 * @author Julien Roche
	 *
	 */
	public enum SnapModeEnum {
		BOTH,
		INNER,
		OUTER;
	}
	
	// Constants
	/** Constant of serialization */
	private static final long serialVersionUID = 1L;
	
	/** Properties on the ui parameter (use it into callback functions) : 
	 * the jQuery object representing the helper that's being dragged  */
	public static final String UI_HELPER = "ui.helper";
	/** Properties on the ui parameter (use it into callback functions) :
	 * current position of the helper as { top, left } object, relative to the 
	 * offset element  */
	public static final String UI_POSITION = "ui.position";
	/** Properties on the ui parameter (use it into callback functions) :
	 * current absolute position of the helper as { top, left } object, relative 
	 * to page */
	public static final String UI_OFFSET = "ui.offset";
	
	// Properties
	private Options options;
	
	/**
	 * Default constructor
	 */
	public DraggableBehavior() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.odlabs.wiquery.core.behavior.WiQueryAbstractBehavior#contribute(org.odlabs.wiquery.core.commons.WiQueryResourceManager)
	 */
	@Override
	public void contribute(WiQueryResourceManager wiQueryResourceManager) {
		wiQueryResourceManager
				.addJavaScriptResource(CoreUIJavaScriptResourceReference.get());
		wiQueryResourceManager
				.addJavaScriptResource(DraggableJavaScriptResourceLocator.get());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.odlabs.wiquery.core.behavior.WiQueryAbstractBehavior#statement()
	 */
	@Override
	public JsStatement statement() {
		return new JsQuery(getComponent()).$().chain("draggable");
	}
	
	/**Method retrieving the options of the component
	 * @return the options
	 */
	protected Options getOptions() {
		return options;
	}
	
	/*---- Options section ---*/
	
	/**f set to false, will prevent the ui-draggable class from being added. 
	 * This may be desired as a performance optimization when calling .draggable() 
	 * init on many hundreds of elements.
	 * @param addClasses
	 */
	public void setAddClasses(boolean addClasses) {
		this.options.put("addClasses", addClasses);
	}
	
	/**
	 * @return the addClasses option
	 */
	public boolean isAddClasses() {
		if(this.options.containsKey("addClasses")){
			return this.options.getBoolean("addClasses");
		}
		
		return true;
	}
	
	/**The element passed to or selected by the appendTo option will be used as 
	 * the draggable helper's container during dragging. By default, the helper 
	 * is appended to the same container as the draggable.
	 * @param appendTo
	 */
	public void setAppendTo(String appendTo) {
		this.options.putLiteral("appendTo", appendTo);
	}
	
	/**
	 * @return the appendTo option value
	 */
	public String getAppendTo() {
		String appendTo = this.options.getLiteral("appendTo");
		return appendTo == null ? "parent" : appendTo;
	}
	
	/**Constrains dragging to either the horizontal (x) or vertical (y) axis. 
	 * Possible values: 'x', 'y'.
	 * @param axis
	 */
	public void setAxis(AxisEnum axis) {
		this.options.putLiteral("axis", axis.toString().toLowerCase());
	}
	
	/**
	 * @return the axis option value
	 */
	public AxisEnum getAxis() {
		return AxisEnum.valueOf(this.options.getLiteral("axis").toUpperCase());
	}
	
	/** Set's the prevent selecting if you start on elements matching the selector
	 * @param cancel Selector (default : ':input,option')
	 */
	public void setCancel(String cancel) {
		this.options.putLiteral("cancel", cancel);
	}
	
	/**
	 * @return the cancel option value
	 */
	public String getCancel() {
		return this.options.getLiteral("cancel");
	}
	
	/**Allows the draggable to be dropped onto the specified sortables. If this 
	 * option is used (helper must be set to 'clone' in order to work flawlessly), 
	 * a draggable can be dropped onto a sortable list and then becomes part of it. 
	 * @param connectToSortable
	 */
	public void setConnectToSortable(String connectToSortable) {
		this.options.putLiteral("connectToSortable", connectToSortable);
	}
	
	/**
	 * @return the connectToSortable option value
	 */
	public String getConnectToSortable() {
		return this.options.getLiteral("connectToSortable");
	}
	
	/**Set's the constrains dragging to within the bounds of the specified element 
	 * or region. Possible string values: 'parent', 'document', 'window', [x1, y1, x2, y2]
	 * @param containment
	 */
	public void setHelper(DraggableContainment containment) {
		this.options.put("containment", containment);
	}
	
	/**
	 * @return the containment option
	 */
	public DraggableContainment getContainment() {
		IComplexOption containment = this.options.getComplexOption("containment");
		if(containment != null && containment instanceof DraggableContainment){
			return (DraggableContainment) containment;
		}
			
		return null;
	}
	
	/**Set the css cursor during the drag operation.
	 * @param cursor
	 */
	public void setCursor(String cursor) {
		this.options.putLiteral("cursor", cursor);
	}
	
	/**
	 * @return the cursor option value
	 */
	public String getCursor() {
		return this.options.getLiteral("cursor");
	}
	
	/**Moves the dragging helper so the cursor always appears to drag from the same 
	 * position. Coordinates can be given as a hash using a combination of one or 
	 * two keys: { top, left, right, bottom }.
	 * @param cusorAt
	 */
	public void setCursorAt(CursorAtEnum cusorAt) {
		this.options.putLiteral("cusorAt", cusorAt.toString().toLowerCase()
				.replace('_', ' '));
	}
	
	/**
	 * @return the cursorAt option value
	 */
	public CursorAtEnum getCursorAt() {
		return CursorAtEnum.valueOf(this.options.getLiteral("cursorAt").toUpperCase()
				.replace(' ', '_'));
	}
	
	/**Time in milliseconds after mousedown until dragging should start. This 
	 * option can be used to prevent unwanted drags when clicking on an element.
	 * @param delay
	 */
	public void setDelay(int delay) {
		this.options.put("delay", delay);
	}
	
	/**
	 * @return the delay option value
	 */
	public int getDelay() {
		if(this.options.containsKey("delay")){
			return this.options.getInt("delay");
		}
		
		return 0;
	}
	
	/** Set's the distance in pixels after mousedown the mouse must move before 
	 * dragging should start. This option can be used to prevent unwanted drags 
	 * when clicking on an element.
	 * @param distance
	 */
	public void setDistance(int distance) {
		this.options.put("distance", distance);
	}
	

	/**
	 * @return the distance option value
	 */
	public int getDistance() {
		if(this.options.containsKey("distance")){
			return this.options.getInt("distance");
		}
		
		return 1;
	}
	
	/**Snaps the dragging helper to a grid, every x and y pixels. Array values: [x, y]
	 * @param x
	 * @param y
	 */
	public void setGrid(int x, int y) {
		ArrayItemOptions<IntegerItemOptions> grids = new ArrayItemOptions<IntegerItemOptions>();
		grids.add(new IntegerItemOptions(x));
		grids.add(new IntegerItemOptions(y));
		this.options.put("grid", grids);
	}
	
	/**
	 * @return the grid option value
	 */
	public ICollectionItemOptions getGrid() {
		return this.options.getListItemOptions("grid");
	}
	
	/**Restricts sort start click to the specified element.
	 * @param handle
	 */
	public void setHandle(String handle) {
		this.options.putLiteral("handle", handle);
	}
	
	/**
	 * @return the handle option value
	 */
	public String getHandle() {
		return this.options.getLiteral("handle");
	}
	
	/**Allows for a helper element to be used for dragging display. Possible 
	 * values: 'original', 'clone', Function. If a function is specified, it 
	 * must return a DOMElement.
	 * @param helper
	 */
	public void setHelper(DraggableHelper helper) {
		this.options.put("helper", helper);
	}
	
	/**
	 * @return the helper option
	 */
	public DraggableHelper getHelper() {
		IComplexOption helper = this.options.getComplexOption("helper");
		if(helper != null && helper instanceof DraggableHelper){
			return (DraggableHelper) helper;
		}
			
		return null;
	}
	
	/**Prevent iframes from capturing the mousemove events during a drag. Useful 
	 * in combination with cursorAt, or in any case, if the mouse cursor is not 
	 * over the helper. If set to true, transparent overlays will be placed over 
	 * all iframes on the page. If a selector is supplied, the matched iframes 
	 * will have an overlay placed over them.
	 * @param iframeFix
	 */
	public void setSnap(DraggableIframeFix iframeFix) {
		this.options.put("iframeFix", iframeFix);
	}
	
	/**
	 * @return the iframeFix option
	 */
	public DraggableIframeFix getIframeFix() {
		IComplexOption iframeFix = this.options.getComplexOption("iframeFix");
		if(iframeFix != null && iframeFix instanceof DraggableIframeFix){
			return (DraggableIframeFix) iframeFix;
		}
			
		return null;
	}
	
	/**Set's the opacity for the helper while being dragged.
	 * @param opacity
	 */
	public void setOpacity(float opacity) {
		this.options.put("opacity", opacity);
	}
	
	/**
	 * @return the opacity option
	 */
	public float getOpacity() {
		if(this.options.containsKey("opacity")){
			return this.options.getFloat("opacity");
		}
		
		return 0.0F;
	}
	
	/**If set to true, all droppable positions are calculated on every mousemove. 
	 * Caution: This solves issues on highly dynamic pages, but dramatically 
	 * decreases performance.
	 * @param refreshPositions
	 */
	public void setRefreshPositions(boolean refreshPositions) {
		this.options.put("refreshPositions", refreshPositions);
	}
	
	/**
	 * @return the refreshPositions option
	 */
	public boolean isRefreshPositions() {
		if(this.options.containsKey("refreshPositions")){
			return this.options.getBoolean("refreshPositions");
		}
		
		return true;
	}
	
	/**If set to true, the element will return to its start position when dragging 
	 * stops. Possible string values: 'valid', 'invalid'. If set to invalid, 
	 * revert will only occur if the draggable has not been dropped on a droppable. 
	 * For valid, it's the other way around.
	 * @param revert
	 */
	public void setRevert(DraggableRevert revert) {
		this.options.put("revert", revert);
	}
	
	/**
	 * @return the revert option
	 */
	public DraggableRevert getRevert() {
		IComplexOption revert = this.options.getComplexOption("revert");
		if(revert != null && revert instanceof DraggableRevert){
			return (DraggableRevert) revert;
		}
			
		return null;
	}
	
	/**Set's the duration of the revert animation, in milliseconds. Ignored if 
	 * revert is false.
	 * @param revertDuration
	 */
	public void setRevertDuration(int revertDuration) {
		this.options.put("revertDuration", revertDuration);
	}
	
	/**
	 * @return the revertDuration option
	 */
	public int getRevertDuration() {
		if(this.options.containsKey("revertDuration")){
			return this.options.getInt("revertDuration");
		}
		
		return 500;
	}
	
	/**Used to group sets of draggable and droppable items, in addition to 
	 * droppable's accept option. A draggable with the same scope value as a 
	 * droppable will be accepted by the droppable.
	 * @param scope
	 */
	public void setScope(String scope) {
		this.options.putLiteral("scope", scope);
	}
	
	/**
	 * @return the scope option
	 */
	public String getScope() {
		if(this.options.containsKey("scope")){
			return this.options.getLiteral("scope");
		}
		
		return "default";
	}
	
	/**If set to true, container auto-scrolls while dragging.
	 * @param scroll
	 */
	public void setScroll(boolean scroll) {
		this.options.put("scroll", scroll);
	}
	
	/**
	 * @return the scroll option
	 */
	public boolean isScroll() {
		if(this.options.containsKey("scroll")){
			return this.options.getBoolean("scroll");
		}
		
		return true;
	}
	
	/**Set's the distance in pixels from the edge of the viewport after which the 
	 * viewport should scroll. Distance is relative to pointer, not the draggable.
	 * @param scrollSensitivity
	 */
	public void setScrollSensitivity(int scrollSensitivity) {
		this.options.put("scrollSensitivity", scrollSensitivity);
	}
	
	/**
	 * @return the scrollSensitivity option
	 */
	public int getScrollSensitivity() {
		if(this.options.containsKey("scrollSensitivity")){
			return this.options.getInt("scrollSensitivity");
		}
		
		return 20;
	}
	
	/**Set's speed at which the window should scroll once the mouse pointer gets 
	 * within the scrollSensitivity distance.
	 * @param scrollSpeed
	 */
	public void setScrollSpeed(int scrollSpeed) {
		this.options.put("scrollSpeed", scrollSpeed);
	}
	
	/**
	 * @return the scrollSpeed option
	 */
	public int getScrollSpeed() {
		if(this.options.containsKey("scrollSpeed")){
			return this.options.getInt("scrollSpeed");
		}
		
		return 20;
	}
	
	/**If set to a selector or to true (equivalent to '.ui-draggable'), the 
	 * draggable will snap to the edges of the selected elements when near an 
	 * edge of the element.
	 * @param snap
	 */
	public void setSnap(DraggableSnap snap) {
		this.options.put("snap", snap);
	}
	
	/**
	 * @return the snap option
	 */
	public DraggableSnap getSnap() {
		IComplexOption snap = this.options.getComplexOption("snap");
		if(snap != null && snap instanceof DraggableSnap){
			return (DraggableSnap) snap;
		}
			
		return null;
	}

	/**Sets the edges of snap elements the draggable will snap to. Ignored if 
	 * snap is false. Possible values: 'inner', 'outer', 'both'
	 * @param snapMode
	 */
	public void setSnapMode(SnapModeEnum snapMode) {
		options.putLiteral("snapMode", snapMode.name().toLowerCase());
	}

	/**
	 * Returns the snapMode option
	 */
	public SnapModeEnum getSnapMode() {
		String literal = options.getLiteral("snapMode");
		return SnapModeEnum.valueOf(literal.toUpperCase());
	}
	
	/**Set's distance in pixels from the snap element edges at which snapping 
	 * should occur. Ignored if snap is false.
	 * @param snapTolerance
	 */
	public void setSnapTolerance(int snapTolerance) {
		this.options.put("snapTolerance", snapTolerance);
	}
	
	/**
	 * @return the snapTolerance option
	 */
	public int getSnapTolerance() {
		if(this.options.containsKey("snapTolerance")){
			return this.options.getInt("snapTolerance");
		}
		
		return 20;
	}
	
	/**
	 * Controls the z-Index of the defined group (key 'group' in the hash, 
	 * accepts jQuery selector) automatically, always brings to front the dragged 
	 * item. Very useful in things like window managers. Optionally, a 'min' key 
	 * can be set, so the zIndex cannot go below that value.
	 * @param stack
	 */
	public void setStack(String stack) {
		this.options.put("stack", stack);
	}

	/**
	 * @returns the stack option
	 */
	public String isStack() {		
		return this.options.get("stack");
	}
	
	/**Set's the starting z-index
	 * @param zIndex
	 */
	public void setZIndex(int zIndex) {
		this.options.put("zIndex", zIndex);
	}
	
	/**
	 * @return the starting z-index
	 */
	public int getZIndex() {
		if(this.options.containsKey("zIndex")){
			return this.options.getInt("zIndex");
		}
		
		return 0;
	}
	
	/*---- Events section ---*/
	
	/**Set's the callback when the mouse is moved during the dragging
	 * @param drag
	 */
	public void setDragEvent(JsScopeUiEvent drag) {
		this.options.put("drag", drag);
	}
	
	/**Set's the callback when the user starts dragging.
	 * @param start
	 */
	public void setStartEvent(JsScopeUiEvent start) {
		this.options.put("start", start);
	}
	
	/**Set's the callback when the user stops dragging.
	 * @param stop
	 */
	public void setStopEvent(JsScopeUiEvent stop) {
		this.options.put("stop", stop);
	}

	
	/*---- Methods section ---*/
	
	/**Method to destroy the draggable
	 * This will return the element back to its pre-init state.
	 * @return the associated JsStatement
	 */
	public JsStatement destroy() {
		return new JsQuery(getComponent()).$().chain("draggable", "'destroy'");
	}

	/**Method to destroy the draggable within the ajax request
	 * @param ajaxRequestTarget
	 */
	public void destroy(AjaxRequestTarget ajaxRequestTarget) {
		ajaxRequestTarget.appendJavascript(this.destroy().render().toString());
	}
	
	/**Method to disable the draggable
	 * @return the associated JsStatement
	 */
	public JsStatement disable() {
		return new JsQuery(getComponent()).$().chain("draggable", "'disable'");
	}

	/**Method to disable the draggable within the ajax request
	 * @param ajaxRequestTarget
	 */
	public void disable(AjaxRequestTarget ajaxRequestTarget) {
		ajaxRequestTarget.appendJavascript(this.disable().render().toString());
	}
	
	/**Method to enable the draggable
	 * @return the associated JsStatement
	 */
	public JsStatement enable() {
		return new JsQuery(getComponent()).$().chain("draggable", "'enable'");
	}

	/**Method to enable the draggable within the ajax request
	 * @param ajaxRequestTarget
	 */
	public void enable(AjaxRequestTarget ajaxRequestTarget) {
		ajaxRequestTarget.appendJavascript(this.enable().render().toString());
	}
}