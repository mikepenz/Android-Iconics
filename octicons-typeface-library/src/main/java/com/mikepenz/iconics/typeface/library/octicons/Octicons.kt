/*
 * Copyright 2019 Mike Penz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mikepenz.iconics.typeface.library.octicons

import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.iconics.typeface.ITypeface
import java.util.LinkedList

@Suppress("EnumEntryName")
object Octicons : ITypeface {

    override val fontRes: Int
        get() = R.font.octicons_v3_2_0

    override val characters: Map<String, Char> by lazy {
        Icon.values().associate { it.name to it.character }
    }

    override val mappingPrefix: String
        get() = "oct"

    override val fontName: String
        get() = "Octicons"

    override val version: String
        get() = "3.2.0"

    override val iconCount: Int
        get() = characters.size

    override val icons: List<String>
        get() = characters.keys.toCollection(LinkedList())

    override val author: String
        get() = "GitHub"

    override val url: String
        get() = "https://github.com/github/octicons"

    override val description: String
        get() = "GitHub's icon font https://octicons.github.com/"

    override val license: String
        get() = " SIL OFL 1.1"

    override val licenseUrl: String
        get() = "http://scripts.sil.org/OFL"

    override fun getIcon(key: String): IIcon = Icon.valueOf(key)

    enum class Icon constructor(override val character: Char) : IIcon {
        //Octicons
        oct_alert('\uf02d'),
        oct_arrow_down('\uf03f'),
        oct_arrow_left('\uf040'),
        oct_arrow_right('\uf03e'),
        oct_arrow_small_down('\uf0a0'),
        oct_arrow_small_left('\uf0a1'),
        oct_arrow_small_right('\uf071'),
        oct_arrow_small_up('\uf09f'),
        oct_arrow_up('\uf03d'),
        oct_microscope('\uf0dd'),
        oct_beaker('\uf0dd'),
        oct_bell('\uf0de'),
        oct_bold('\uf0e2'),
        oct_book('\uf007'),
        oct_bookmark('\uf07b'),
        oct_briefcase('\uf0d3'),
        oct_broadcast('\uf048'),
        oct_browser('\uf0c5'),
        oct_bug('\uf091'),
        oct_calendar('\uf068'),
        oct_check('\uf03a'),
        oct_checklist('\uf076'),
        oct_chevron_down('\uf0a3'),
        oct_chevron_left('\uf0a4'),
        oct_chevron_right('\uf078'),
        oct_chevron_up('\uf0a2'),
        oct_circle_slash('\uf084'),
        oct_circuit_board('\uf0d6'),
        oct_clippy('\uf035'),
        oct_clock('\uf046'),
        oct_cloud_download('\uf00b'),
        oct_cloud_upload('\uf00c'),
        oct_code('\uf05f'),
        oct_color_mode('\uf065'),
        oct_comment_add('\uf02b'),
        oct_comment('\uf02b'),
        oct_comment_discussion('\uf04f'),
        oct_credit_card('\uf045'),
        oct_dash('\uf0ca'),
        oct_dashboard('\uf07d'),
        oct_database('\uf096'),
        oct_clone('\uf0dc'),
        oct_desktop_download('\uf0dc'),
        oct_device_camera('\uf056'),
        oct_device_camera_video('\uf057'),
        oct_device_desktop('\uf27c'),
        oct_device_mobile('\uf038'),
        oct_diff('\uf04d'),
        oct_diff_added('\uf06b'),
        oct_diff_ignored('\uf099'),
        oct_diff_modified('\uf06d'),
        oct_diff_removed('\uf06c'),
        oct_diff_renamed('\uf06e'),
        oct_ellipsis('\uf09a'),
        oct_eye_unwatch('\uf04e'),
        oct_eye_watch('\uf04e'),
        oct_eye('\uf04e'),
        oct_file_binary('\uf094'),
        oct_file_code('\uf010'),
        oct_file_directory('\uf016'),
        oct_file_media('\uf012'),
        oct_file_pdf('\uf014'),
        oct_file_submodule('\uf017'),
        oct_file_symlink_directory('\uf0b1'),
        oct_file_symlink_file('\uf0b0'),
        oct_file_text('\uf011'),
        oct_file_zip('\uf013'),
        oct_flame('\uf0d2'),
        oct_fold('\uf0cc'),
        oct_gear('\uf02f'),
        oct_gift('\uf042'),
        oct_gist('\uf00e'),
        oct_gist_secret('\uf08c'),
        oct_git_branch_create('\uf020'),
        oct_git_branch_delete('\uf020'),
        oct_git_branch('\uf020'),
        oct_git_commit('\uf01f'),
        oct_git_compare('\uf0ac'),
        oct_git_merge('\uf023'),
        oct_git_pull_request_abandoned('\uf009'),
        oct_git_pull_request('\uf009'),
        oct_globe('\uf0b6'),
        oct_graph('\uf043'),
        oct_heart('\u2665'),
        oct_history('\uf07e'),
        oct_home('\uf08d'),
        oct_horizontal_rule('\uf070'),
        oct_hubot('\uf09d'),
        oct_inbox('\uf0cf'),
        oct_info('\uf059'),
        oct_issue_closed('\uf028'),
        oct_issue_opened('\uf026'),
        oct_issue_reopened('\uf027'),
        oct_italic('\uf0e4'),
        oct_jersey('\uf019'),
        oct_key('\uf049'),
        oct_keyboard('\uf00d'),
        oct_law('\uf0d8'),
        oct_light_bulb('\uf000'),
        oct_link('\uf05c'),
        oct_link_external('\uf07f'),
        oct_list_ordered('\uf062'),
        oct_list_unordered('\uf061'),
        oct_location('\uf060'),
        oct_gist_private('\uf06a'),
        oct_mirror_private('\uf06a'),
        oct_git_fork_private('\uf06a'),
        oct_lock('\uf06a'),
        oct_logo_github('\uf092'),
        oct_mail('\uf03b'),
        oct_mail_read('\uf03c'),
        oct_mail_reply('\uf051'),
        oct_mark_github('\uf00a'),
        oct_markdown('\uf0c9'),
        oct_megaphone('\uf077'),
        oct_mention('\uf0be'),
        oct_milestone('\uf075'),
        oct_mirror_public('\uf024'),
        oct_mirror('\uf024'),
        oct_mortar_board('\uf0d7'),
        oct_mute('\uf080'),
        oct_no_newline('\uf09c'),
        oct_octoface('\uf008'),
        oct_organization('\uf037'),
        oct_package('\uf0c4'),
        oct_paintcan('\uf0d1'),
        oct_pencil('\uf058'),
        oct_person_add('\uf018'),
        oct_person_follow('\uf018'),
        oct_person('\uf018'),
        oct_pin('\uf041'),
        oct_plug('\uf0d4'),
        oct_repo_create('\uf05d'),
        oct_gist_new('\uf05d'),
        oct_file_directory_create('\uf05d'),
        oct_file_add('\uf05d'),
        oct_plus('\uf05d'),
        oct_primitive_dot('\uf052'),
        oct_primitive_square('\uf053'),
        oct_pulse('\uf085'),
        oct_question('\uf02c'),
        oct_quote('\uf063'),
        oct_radio_tower('\uf030'),
        oct_repo_delete('\uf001'),
        oct_repo('\uf001'),
        oct_repo_clone('\uf04c'),
        oct_repo_force_push('\uf04a'),
        oct_gist_fork('\uf002'),
        oct_repo_forked('\uf002'),
        oct_repo_pull('\uf006'),
        oct_repo_push('\uf005'),
        oct_rocket('\uf033'),
        oct_rss('\uf034'),
        oct_ruby('\uf047'),
        oct_search_save('\uf02e'),
        oct_search('\uf02e'),
        oct_server('\uf097'),
        oct_settings('\uf07c'),
        oct_shield('\uf0e1'),
        oct_log_in('\uf036'),
        oct_sign_in('\uf036'),
        oct_log_out('\uf032'),
        oct_sign_out('\uf032'),
        oct_squirrel('\uf0b2'),
        oct_star_add('\uf02a'),
        oct_star_delete('\uf02a'),
        oct_star('\uf02a'),
        oct_stop('\uf08f'),
        oct_repo_sync('\uf087'),
        oct_sync('\uf087'),
        oct_tag_remove('\uf015'),
        oct_tag_add('\uf015'),
        oct_tag('\uf015'),
        oct_tasklist('\uf0e5'),
        oct_telescope('\uf088'),
        oct_terminal('\uf0c8'),
        oct_text_size('\uf0e3'),
        oct_three_bars('\uf05e'),
        oct_thumbsdown('\uf0db'),
        oct_thumbsup('\uf0da'),
        oct_tools('\uf031'),
        oct_trashcan('\uf0d0'),
        oct_triangle_down('\uf05b'),
        oct_triangle_left('\uf044'),
        oct_triangle_right('\uf05a'),
        oct_triangle_up('\uf0aa'),
        oct_unfold('\uf039'),
        oct_unmute('\uf0ba'),
        oct_versions('\uf064'),
        oct_watch('\uf0e0'),
        oct_remove_close('\uf081'),
        oct_x('\uf081'),
        oct_zap('\u26A1');

        override val typeface: ITypeface by lazy { Octicons }
    }
}
