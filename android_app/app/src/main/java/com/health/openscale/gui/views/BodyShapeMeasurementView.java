/* Copyright (C) 2014  olie.xdev <olie.xdev@googlemail.com>
*
*    This program is free software: you can redistribute it and/or modify
*    it under the terms of the GNU General Public License as published by
*    the Free Software Foundation, either version 3 of the License, or
*    (at your option) any later version.
*
*    This program is distributed in the hope that it will be useful,
*    but WITHOUT ANY WARRANTY; without even the implied warranty of
*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*    GNU General Public License for more details.
*
*    You should have received a copy of the GNU General Public License
*    along with this program.  If not, see <http://www.gnu.org/licenses/>
*/
package com.health.openscale.gui.views;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import com.health.openscale.R;
import com.health.openscale.core.datatypes.ScaleMeasurement;

public class BodyShapeMeasurementView extends MeasurementView {
    // Don't change key value, it may be stored persistent in preferences
    public static final String KEY = "body_shape";

    private String bodyshape;

    public BodyShapeMeasurementView(Context context) {
        super(context, R.string.bodyshape_title, R.drawable.ic_whr);
    }

    @Override
    public String getKey() {
        return KEY;
    }

    private void setValue(String newComment, boolean callListener) {
        if (!newComment.equals(bodyshape)) {
            bodyshape = newComment;
            setValueView(bodyshape, callListener);
        }
    }

    @Override
    public void loadFrom(ScaleMeasurement measurement, ScaleMeasurement previousMeasurement) {
        setValue(measurement.getBodyShape(), false);
    }

    @Override
    public void saveTo(ScaleMeasurement measurement) {
        measurement.setBodyShape(bodyshape);
    }

    @Override
    public void clearIn(ScaleMeasurement measurement) {
        measurement.setBodyShape("");
    }

    @Override
    public void restoreState(Bundle state) {
        setValue(state.getString(getKey()), true);
    }

    @Override
    public void saveState(Bundle state) {
        state.putString(getKey(), bodyshape);
    }

    @Override
    public String getValueAsString(boolean withUnit) {
        return bodyshape;
    }

    @Override
    protected View getInputView() {
        EditText input = new EditText(getContext());

        input.setInputType(InputType.TYPE_CLASS_TEXT
                | InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE
                | InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        input.setHint(R.string.bodyshape_hint);
        input.setText(getValueAsString(false));
        input.setSelectAllOnFocus(true);

        return input;
    }

    @Override
    protected boolean validateAndSetInput(View view) {
        EditText editText = (EditText) view;
        setValue(editText.getText().toString(), true);
        return true;
    }
}
