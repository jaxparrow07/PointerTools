package com.jaxparrow.pointertools;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.*;

import android.content.Context;
import android.view.PointerIcon;
import android.view.View;

import android.graphics.Bitmap;

import java.io.InputStream;
import java.io.IOException;

public class PointerTools extends AndroidNonvisibleComponent {

  private Context context;
  public PointerIcon mPointer;
  ComponentContainer mContainer;

  public PointerTools(ComponentContainer container) {

    super(container.$form());
    this.context = container.$context();
    this.mContainer = container;

  }


  // Main Functions
  @SimpleFunction(description = "Accepts pointer and a view to set the pointer for. You can either set a system defined pointer or a custom image pointer.")
  public void SetPointer(AndroidViewComponent view, Object pointer) {
    
    View set_view = (View) view.getView();
    PointerIcon icon = (PointerIcon) pointer;
    set_view.setPointerIcon(icon);

  }

  @SimpleFunction(description = "Gets pointer of a view if set.")
  public Object GetPointer(AndroidViewComponent view) {
    
    View set_view = (View) view.getView();
    return set_view.getPointerIcon();

  }

  @SimpleFunction(description = "Returns poiner from system defined icons. Use integers or property blocks.")
  public Object GetPointerFromSystem(int type) {
    
    return (Object) mPointer.getSystemIcon(context, type);

  }

  @SimpleFunction(description = "Returns pointer from custom image. You can set X and Y offset."+"Returns default pointer if any error occurs.")
  public Object GetPointerFromImage(String image, int offsetX, int offsetY) {


    InputStream in;
    Bitmap bmp_pointer;

    try
    
    {
      bmp_pointer = MediaUtil.getBitmapDrawable(mContainer.$form(), image).getBitmap();
            
      float floatX = (float) offsetX;
      float floatY = (float) offsetY;
      
      return (Object) mPointer.create(bmp_pointer,floatX,floatY);

    }

    catch(IOException ioException)
    
    {
      return (Object) mPointer.getSystemIcon(context, 1000);
    }

  }

  @SimpleFunction(description = "Resets the pointer icon for the view.")
  public void ResetPointer(AndroidViewComponent view) {
    
    View set_view = (View) view.getView();
    set_view.setPointerIcon(null);

  }

  @SimpleFunction(description = "This text will be shown when hovered by pointer or long pressed.")
  public void SetToolTip(AndroidViewComponent view, String text) {
    
    View set_view = (View) view.getView();
    set_view.setTooltipText(text);

  }

  @SimpleFunction(description = "Returns the Tooltip text of a view if set.")
  public String GetToolTip(AndroidViewComponent view) {
    
    View set_view = (View) view.getView();
    return (String) set_view.getTooltipText();

  }

  // Properties for poiner types.
  @SimpleProperty
  public int TypeAlias(){
    return 1010;
  }

  @SimpleProperty
  public int TypeAllScroll(){
    return 1013;
  }


  @SimpleProperty
  public int TypeDefault(){
    return 1000;
  }

  @SimpleProperty
  public int TypeCell(){
    return 1006;
  }

  @SimpleProperty
  public int TypeContextMenu(){
    return 1001;
  }

  @SimpleProperty
  public int TypeCopy(){
    return 1011;
  }

  @SimpleProperty
  public int TypeCrosshair(){
    return 1007;
  }

  @SimpleProperty
  public int TypeGrab(){
    return 1020;
  }

  @SimpleProperty
  public int TypeGrabbing(){
    return 1021;
  }

  @SimpleProperty
  public int TypeHand(){
    return 1002;
  }

  @SimpleProperty
  public int TypeHelp(){
    return 1003;
  }

  @SimpleProperty
  public int TypeHorizntalDoubleArrow(){
    return 1014;
  }

  @SimpleProperty
  public int TypeNoDrop(){
    return 1012;
  }

  @SimpleProperty(description = "Blank Cursor")
  public int TypeNull(){
    return 0;
  }

  @SimpleProperty
  public int TypeText(){
    return 1008;
  }

  @SimpleProperty
  public int TypeTopLeftDiagonalDoubleArrow(){
    return 1017;
  }

  @SimpleProperty
  public int TypeTopRightDiagonalDoubleArrow(){
    return 1016;
  }

  @SimpleProperty
  public int TypeVerticalDoubleArrow(){
    return 1015;
  }

  @SimpleProperty
  public int TypeVerticalText(){
    return 1009;
  }

  @SimpleProperty(description = "Animated waiting cursor.")
  public int TypeWait(){
    return 1004;
  }

  @SimpleProperty
  public int TypeZoomIn(){
    return 1018;
  }

  @SimpleProperty
  public int TypeZoomOut(){
    return 1019;
  }


}
