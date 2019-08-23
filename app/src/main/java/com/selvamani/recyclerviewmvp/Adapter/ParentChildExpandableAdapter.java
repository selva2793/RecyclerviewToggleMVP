package com.selvamani.recyclerviewmvp.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.selvamani.recyclerviewmvp.R;
import com.selvamani.recyclerviewmvp.Remote.Datamodel.ParentModel;
import com.suke.widget.SwitchButton;

import java.util.List;

public class ParentChildExpandableAdapter extends BaseExpandableListAdapter {
    public static Context context;

    int Selectedparentposition = -1;
    boolean checked = false;
    boolean Childchecked = false;
    List<ParentModel> mparentModels;


    public ParentChildExpandableAdapter(Context context, List<ParentModel> parentModels) {
        this.context = context;
        this.mparentModels = parentModels;
    }

    @Override
    public int getGroupCount() {
        return this.mparentModels.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return (this.mparentModels.get(groupPosition).getChildarray().size());
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.mparentModels.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.mparentModels.get(groupPosition).getChildarray().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.parent_design, parent, false);
        }

        TextView parentheading = (TextView) convertView.findViewById(R.id.tv_parent);
        SwitchButton parentSwitch = (SwitchButton) convertView.findViewById(R.id.switch_parent);

        parentheading.setText("" + mparentModels.get(groupPosition).getId());

        if (Childchecked) {

            if (Selectedparentposition != -1 && Selectedparentposition == groupPosition) {
                if (checked) {
                    parentSwitch.setChecked(true);
                } else {
                    parentSwitch.setChecked(false);
                }
            }
        }

        parentSwitch.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                //TODO do your job
                // Let the event be handled in onItemClick()
                Selectedparentposition = groupPosition;
                checked = isChecked;
                Childchecked = false;
              notifyDataSetChanged();

            }
        });


        ExpandableListView mExpandableListView = (ExpandableListView) parent;
//        mExpandableListView.expandGroup(groupPosition);
        mExpandableListView.clearAnimation();
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.child_design, parent, false);
                convertView.setPadding(0, 0, 0, 0);
            }

        TextView childheading = (TextView) convertView.findViewById(R.id.tv_child);
        SwitchButton childSwitch = (SwitchButton) convertView.findViewById(R.id.switch_child);
        childheading.setText("" + mparentModels.get(groupPosition).getChildarray().get(childPosition).getId());

        if (Selectedparentposition != -1 && Selectedparentposition == groupPosition){
            if (checked) {
                childSwitch.setChecked(true);
            }
            else{
                childSwitch.setChecked(false);
            }
        }


        childSwitch.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                //TODO do your job
                // Let the event be handled in onItemClick()
                Selectedparentposition = groupPosition;
                checked = isChecked;
                if (isChecked == true) {
                    Childchecked = true;
                    notifyDataSetChanged();
                }

            }
        });


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

//    @Override
//    public int getChildTypeCount() {
//        return 2;
//    }

//    @Override
//    public int getChildType(final int groupPosition, final int childPosition) {
//
//        if (childPosition == mparentModels.get(groupPosition).ge().size()) {
//            return 1;
//        } else {
//            return 0;
//        }
//    }




}
